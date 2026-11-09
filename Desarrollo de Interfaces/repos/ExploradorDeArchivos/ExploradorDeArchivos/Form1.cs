namespace ExploradorDeArchivos
{
    public partial class fmrInicial : Form
    {
        public fmrInicial()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            String[] unidades = Directory.GetLogicalDrives();
            foreach (string s in unidades)
            {
                trvArbol.Nodes.Add(s);
            }
        }

        private void trvArbol_AfterSelect(object sender, TreeViewEventArgs e)
        {
            String unidad = trvArbol.SelectedNode.Text;
            String[] directorios = Directory.GetDirectories(unidad);
            foreach (string s in directorios)
            {
                TreeNode nodo = trvArbol.Nodes.Add(s);
                //nodo.Text = nombre del directorio
                nodo.Tag = s;
            }
            String[] ficheros = Directory.GetFiles(unidad);
            // e.node -> también sirve
        }
    }
}
