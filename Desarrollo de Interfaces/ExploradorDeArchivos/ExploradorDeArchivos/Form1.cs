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
            TreeNode nodoSeleccionado = e.Node;

            string ruta = "";
            if (nodoSeleccionado.Tag != null)
            {
                ruta = nodoSeleccionado.Tag.ToString();
            }
            else
            {
                ruta = nodoSeleccionado.Text;
            }

            try
            {
                // 1. Limpiamos nodos hijos anteriores del árbol
                nodoSeleccionado.Nodes.Clear();

                // 2. Cargar carpetas (lo que ya tenías funcionando)
                String[] directorios = Directory.GetDirectories(ruta);
                foreach (string s in directorios)
                {
                    DirectoryInfo infoDir = new DirectoryInfo(s);
                    TreeNode nodo = new TreeNode(infoDir.Name);
                    nodo.Tag = s;
                    nodoSeleccionado.Nodes.Add(nodo);
                }

                // 3. LIMPIAR EL LISTVIEW ANTES DE CARGAR NUEVOS DATOS (Usando tu nombre: lvArchivos)
                lvArchivos.Items.Clear();
                lvArchivos.Columns.Clear();

                // Creamos las columnas que pide la práctica (Nombre, Fechas...)
                lvArchivos.Columns.Add("Nombre", 150);
                lvArchivos.Columns.Add("Fecha creación", 130);
                lvArchivos.Columns.Add("Fecha modificación", 130);
                lvArchivos.Columns.Add("Fecha acceso", 130);

                // 4. CARGAR LOS FICHEROS EN EL LISTVIEW
                String[] ficheros = Directory.GetFiles(ruta);
                foreach (string f in ficheros)
                {
                    FileInfo infoFichero = new FileInfo(f);

                    // Creamos un elemento para la fila con el nombre del fichero
                    ListViewItem item = new ListViewItem(infoFichero.Name);

                    // Añadimos las subcolumnas con las fechas
                    item.SubItems.Add(infoFichero.CreationTime.ToString());
                    item.SubItems.Add(infoFichero.LastWriteTime.ToString());
                    item.SubItems.Add(infoFichero.LastAccessTime.ToString());

                    // Metemos la fila entera en tu ListView
                    lvArchivos.Items.Add(item);
                }
            }
            catch (UnauthorizedAccessException)
            {
                MessageBox.Show("No tienes permisos para ver esta carpeta.", "Aviso");
            }
            catch (Exception ex)
            {
                // Por si ocurre cualquier otro despiste
            }
        }
    }
}
