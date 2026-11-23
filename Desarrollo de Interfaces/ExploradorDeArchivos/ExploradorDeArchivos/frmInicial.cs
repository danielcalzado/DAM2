namespace ExploradorDeArchivos
{
    public partial class fmrInicial : Form
    {
        // Guardamos aquí la carpeta en la que estamos situados en cada momento
        private string rutaActual = "";

        public fmrInicial()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // 1. Configuramos el ListView UNA SOLA VEZ al arrancar
            lvArchivos.View = View.Details;
            lvArchivos.FullRowSelect = true; // Para poder seleccionar toda la fila al hacer clic

            lvArchivos.Columns.Add("Nombre", 150);
            lvArchivos.Columns.Add("Fecha creación", 130);
            lvArchivos.Columns.Add("Fecha modificación", 130);
            lvArchivos.Columns.Add("Fecha acceso", 130);

            // 2. Cargamos los discos duros
            string[] unidades = Directory.GetLogicalDrives();
            foreach (string s in unidades)
            {
                TreeNode nodoUnidad = new TreeNode(s, 0, 0);
                nodoUnidad.Tag = s; // Guardamos la ruta también en el Tag por coherencia
                trvArbol.Nodes.Add(nodoUnidad);
            }
        }

        private void trvArbol_AfterSelect(object sender, TreeViewEventArgs e)
        {
            TreeNode nodoSeleccionado = e.Node;

            // Actualizamos la ruta global
            rutaActual = nodoSeleccionado.Tag.ToString();

            try
            {
                // 1. Cargar subcarpetas en el árbol
                nodoSeleccionado.Nodes.Clear();
                string[] directorios = Directory.GetDirectories(rutaActual);

                foreach (string s in directorios)
                {
                    DirectoryInfo infoDir = new DirectoryInfo(s);
                    TreeNode nodo = new TreeNode(infoDir.Name, 1, 1);
                    nodo.Tag = s;
                    nodoSeleccionado.Nodes.Add(nodo);
                }

                // 2. Cargar archivos en el ListView
                lvArchivos.Items.Clear();
                string[] ficheros = Directory.GetFiles(rutaActual);

                foreach (string f in ficheros)
                {
                    FileInfo infoFichero = new FileInfo(f);
                    ListViewItem item = new ListViewItem(infoFichero.Name, 2);

                    // Guardamos la ruta completa del archivo en su bolsillo oculto
                    item.Tag = f;

                    item.SubItems.Add(infoFichero.CreationTime.ToString());
                    item.SubItems.Add(infoFichero.LastWriteTime.ToString());
                    item.SubItems.Add(infoFichero.LastAccessTime.ToString());

                    lvArchivos.Items.Add(item);
                }
            }
            catch (UnauthorizedAccessException)
            {
                MessageBox.Show("No tienes permisos para ver esta carpeta.", "Aviso", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error inesperado: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void toolStripVistasDetalles_Click(object sender, EventArgs e)
        {
            lvArchivos.View = View.Details;
        }

        private void toolStripVistasIconosGrandes_Click(object sender, EventArgs e)
        {
            lvArchivos.View = View.LargeIcon;
        }

        private void toolStripVistasIconosPequenos_Click(object sender, EventArgs e)
        {
            lvArchivos.View = View.SmallIcon;
        }

        private void toolStripVistasLista_Click(object sender, EventArgs e)
        {
            lvArchivos.View = View.List;
        }

        private void carpetaToolStripNuevoCarpeta_Click(object sender, EventArgs e)
        {
            // Si no has seleccionado ningún disco o carpeta todavía, no hacemos nada
            if (string.IsNullOrEmpty(rutaActual))
            {
                MessageBox.Show("Selecciona primero una carpeta donde crearla.", "Aviso");
                return;
            }

            using (frmPedirNombre ventanaNombre = new frmPedirNombre())
            {
                // ShowDialog() abre la ventana bloqueando la principal hasta que se cierre
                if (ventanaNombre.ShowDialog() == DialogResult.OK && !string.IsNullOrEmpty(ventanaNombre.NombreIntroducido))
                {
                    // Path.Combine une rutas poniendo la barra '\' correctamente sin duplicarla
                    string nuevaRuta = Path.Combine(rutaActual, ventanaNombre.NombreIntroducido);

                    try
                    {
                        if (!Directory.Exists(nuevaRuta))
                        {
                            Directory.CreateDirectory(nuevaRuta);
                            // Refrescamos el árbol llamando manualmente al evento AfterSelect
                            trvArbol_AfterSelect(trvArbol, new TreeViewEventArgs(trvArbol.SelectedNode));
                        }
                        else
                        {
                            MessageBox.Show("Ya existe una carpeta con ese nombre.", "Error");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error al crear la carpeta: " + ex.Message, "Error");
                    }
                }
            }
        }

        private void ficheroToolStripNuevoFichero_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(rutaActual))
            {
                MessageBox.Show("Selecciona primero una carpeta donde crear el fichero.", "Aviso");
                return;
            }

            using (frmPedirNombre ventanaNombre = new frmPedirNombre())
            {
                if (ventanaNombre.ShowDialog() == DialogResult.OK && !string.IsNullOrEmpty(ventanaNombre.NombreIntroducido))
                {
                    string nuevaRuta = Path.Combine(rutaActual, ventanaNombre.NombreIntroducido);

                    try
                    {
                        if (!File.Exists(nuevaRuta))
                        {
                            // File.Create deja el archivo abierto en memoria; .Close() es OBLIGATORIO para liberarlo
                            File.Create(nuevaRuta).Close();

                            // Refrescamos la vista
                            trvArbol_AfterSelect(trvArbol, new TreeViewEventArgs(trvArbol.SelectedNode));
                        }
                        else
                        {
                            MessageBox.Show("Ya existe un fichero con ese nombre.", "Error");
                        }
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error al crear el fichero: " + ex.Message, "Error");
                    }
                }
            }
        }

        private void lvArchivos_DoubleClick(object sender, EventArgs e)
        {
            // Comprobamos que haya algún elemento seleccionado
            if (lvArchivos.SelectedItems.Count == 0) return;

            // Sacamos la ruta completa que guardamos antes en el Tag
            string rutaFichero = lvArchivos.SelectedItems[0].Tag.ToString();

            // Obtenemos la extensión en minúsculas (ej: ".txt", ".log", ".ini")
            string extension = Path.GetExtension(rutaFichero).ToLower();

            // Lista de extensiones de texto plano permitidas
            string[] extensionesValidas = { ".txt", ".log", ".ini", ".xml", ".cs", ".json", ".csv" };

            if (extensionesValidas.Contains(extension))
            {
                try
                {
                    frmVisorTexto visor = new frmVisorTexto(rutaFichero);
                    visor.Show();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("No se pudo leer el archivo: " + ex.Message, "Error");
                }
            }
            else
            {
                MessageBox.Show("Este tipo de archivo no se puede abrir como texto.", "Aviso");
            }
        }
    }
}