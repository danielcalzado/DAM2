using System.Drawing.Text;
using System.IO;
namespace Peliculas
{
    public partial class FrmBase : Form
    {
        public static List<string[]> peliculas = new List<string[]>();
        public FrmBase()
        {
            InitializeComponent();
        }

        private void FrmBase_Load(object sender, EventArgs e)
        {
            string ruta = Path.Combine(Application.StartupPath, "Peliculas.txt");

            try
            {
                foreach (string linea in File.ReadAllLines(ruta))
                {
                    if (linea.Trim() == "") continue;

                    string[] campos = linea.Split('#');
                    if (campos.Length < 4) continue;

                    for (int i = 0; i < campos.Length; i++)
                        campos[i] = campos[i].Trim();

                    peliculas.Add(campos);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al leer el fichero: " + ex.Message);
                return;
            }

            // 2. Obtener las clasificaciones distintas
            List<string> clasificaciones = new List<string>();
            foreach (string[] p in peliculas)
            {
                if (!clasificaciones.Contains(p[3]))
                    clasificaciones.Add(p[3]);
            }

            // 3. Crear un RadioButton por clasificación
            int y = 20;
            foreach (string clasificacion in clasificaciones)
            {
                RadioButton rb = new RadioButton();
                rb.Text = clasificacion;
                rb.AutoSize = true;
                rb.Location = new Point(20, y);
                rb.Click += RadioButton_Click;
                Controls.Add(rb);
                y += 30;
            }
        }

        // Controlador común para todos los RadioButton
        private void RadioButton_Click(object sender, EventArgs e)
        {
            RadioButton rb = (RadioButton)sender;
            
            lstTitulos.Items.Clear();
            lstActores.Items.Clear();
            lstDirectores.Items.Clear();

            foreach (string[] p in peliculas)
            {
                if (p[3] == rb.Text)
                {
                    lstTitulos.Items.Add(p[0]);
                    lstActores.Items.Add(p[1]);
                    lstDirectores.Items.Add(p[2]);
                }
            }
        }
    }
}
