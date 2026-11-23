namespace EjercicioRepaso
{
    public partial class Form1 : Form
    {
        private List<Producto> productos = new List<Producto>();
        public Form1()
        {
            InitializeComponent();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            if (File.Exists(@"C:\Temp\Productos.txt"))
            {
                string[] lineas = File.ReadAllLines(@"C:\Temp\Productos.txt");
                foreach (string linea in lineas)
                {
                    string[] datos = linea.Split(';');
                    Producto p = new Producto(int.Parse(datos[0].Trim()), datos[1].Trim(), int.Parse(datos[2].Trim()), datos[3].Trim());
                    productos.Add(p);
                }
                List<string> categorias = new List<string>();
                foreach (Producto p in productos)
                {
                    if (!categorias.Contains(p.Categoria))
                    {
                        categorias.Add(p.Categoria);
                    }
                }
                Button[] botones = { button1, button2, button3, button4, button5, button6, button7 };
                for (int i = 0; i < botones.Length; i++)
                {
                    if (i < categorias.Count)
                    {
                        botones[i].Text = categorias[i];
                    } else
                    {
                        botones[i].Visible = false; // Ocultar los botones que sobran
                    }
                }
                lvProductos.View = View.Details;
                lvProductos.FullRowSelect = true; // Para que al pinchar se marque la linea entera

                lvProductos.Columns.Add("ID", 50);
                lvProductos.Columns.Add("Nombre", 180);
                lvProductos.Columns.Add("Stock", 80);
                lvProductos.Columns.Add("Categoria", 130);
            }
        }

        private void BotonCategoria_Click(object sender, EventArgs e)
        {
            Button btnPulsado = (Button)sender;
            string categoriaSeleccionada = btnPulsado.Text;
            lvProductos.Items.Clear();

            foreach (Producto p in productos)
            {
                if (p.Categoria == categoriaSeleccionada)
                {
                    ListViewItem fila = new ListViewItem(p.Id.ToString());
                    fila.SubItems.Add(p.Nombre);
                    fila.SubItems.Add(p.Stock.ToString());
                    fila.SubItems.Add(p.Categoria);

                    lvProductos.Items.Add(fila);
                }
            }
        }
    }
}
