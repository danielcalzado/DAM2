namespace ExploradorDeArchivos
{
    partial class fmrInicial
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(fmrInicial));
            trvArbol = new TreeView();
            lvArchivos = new ListView();
            toolStrip1 = new ToolStrip();
            tsNuevo = new ToolStripSplitButton();
            carpetaToolStripNuevoCarpeta = new ToolStripMenuItem();
            ficheroToolStripNuevoFichero = new ToolStripMenuItem();
            tsVistas = new ToolStripSplitButton();
            toolStripVistasDetalles = new ToolStripMenuItem();
            toolStripVistasIconosGrandes = new ToolStripMenuItem();
            toolStripVistasIconosPequenos = new ToolStripMenuItem();
            toolStripVistasLista = new ToolStripMenuItem();
            imgPequenos = new ImageList(components);
            imgGrandes = new ImageList(components);
            toolStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // trvArbol
            // 
            trvArbol.ImageIndex = 0;
            trvArbol.ImageList = imgPequenos;
            trvArbol.Location = new Point(72, 78);
            trvArbol.Margin = new Padding(2);
            trvArbol.Name = "trvArbol";
            trvArbol.SelectedImageIndex = 0;
            trvArbol.Size = new Size(276, 343);
            trvArbol.TabIndex = 0;
            trvArbol.AfterSelect += trvArbol_AfterSelect;
            // 
            // lvArchivos
            // 
            lvArchivos.FullRowSelect = true;
            lvArchivos.LargeImageList = imgGrandes;
            lvArchivos.Location = new Point(439, 78);
            lvArchivos.Margin = new Padding(2);
            lvArchivos.Name = "lvArchivos";
            lvArchivos.Size = new Size(569, 343);
            lvArchivos.SmallImageList = imgPequenos;
            lvArchivos.TabIndex = 1;
            lvArchivos.UseCompatibleStateImageBehavior = false;
            lvArchivos.View = View.Details;
            lvArchivos.DoubleClick += lvArchivos_DoubleClick;
            // 
            // toolStrip1
            // 
            toolStrip1.ImageScalingSize = new Size(24, 24);
            toolStrip1.Items.AddRange(new ToolStripItem[] { tsNuevo, tsVistas });
            toolStrip1.Location = new Point(0, 0);
            toolStrip1.Name = "toolStrip1";
            toolStrip1.Size = new Size(1112, 46);
            toolStrip1.TabIndex = 2;
            toolStrip1.Text = "toolStrip1";
            // 
            // tsNuevo
            // 
            tsNuevo.DropDownItems.AddRange(new ToolStripItem[] { carpetaToolStripNuevoCarpeta, ficheroToolStripNuevoFichero });
            tsNuevo.Image = Properties.Resources.favorito;
            tsNuevo.ImageTransparentColor = Color.Magenta;
            tsNuevo.Name = "tsNuevo";
            tsNuevo.Size = new Size(58, 43);
            tsNuevo.Text = "Nuevo";
            tsNuevo.TextDirection = ToolStripTextDirection.Horizontal;
            tsNuevo.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // carpetaToolStripNuevoCarpeta
            // 
            carpetaToolStripNuevoCarpeta.Name = "carpetaToolStripNuevoCarpeta";
            carpetaToolStripNuevoCarpeta.Size = new Size(180, 22);
            carpetaToolStripNuevoCarpeta.Text = "Carpeta";
            carpetaToolStripNuevoCarpeta.Click += carpetaToolStripNuevoCarpeta_Click;
            // 
            // ficheroToolStripNuevoFichero
            // 
            ficheroToolStripNuevoFichero.Name = "ficheroToolStripNuevoFichero";
            ficheroToolStripNuevoFichero.Size = new Size(180, 22);
            ficheroToolStripNuevoFichero.Text = "Fichero";
            ficheroToolStripNuevoFichero.Click += ficheroToolStripNuevoFichero_Click;
            // 
            // tsVistas
            // 
            tsVistas.DropDownItems.AddRange(new ToolStripItem[] { toolStripVistasDetalles, toolStripVistasIconosGrandes, toolStripVistasIconosPequenos, toolStripVistasLista });
            tsVistas.Image = Properties.Resources.ver_carpeta;
            tsVistas.ImageTransparentColor = Color.Magenta;
            tsVistas.Name = "tsVistas";
            tsVistas.Size = new Size(53, 43);
            tsVistas.Text = "Vistas";
            tsVistas.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // toolStripVistasDetalles
            // 
            toolStripVistasDetalles.Name = "toolStripVistasDetalles";
            toolStripVistasDetalles.Size = new Size(180, 22);
            toolStripVistasDetalles.Text = "Detalles";
            toolStripVistasDetalles.Click += toolStripVistasDetalles_Click;
            // 
            // toolStripVistasIconosGrandes
            // 
            toolStripVistasIconosGrandes.Name = "toolStripVistasIconosGrandes";
            toolStripVistasIconosGrandes.Size = new Size(180, 22);
            toolStripVistasIconosGrandes.Text = "Iconos Grandes";
            toolStripVistasIconosGrandes.Click += toolStripVistasIconosGrandes_Click;
            // 
            // toolStripVistasIconosPequenos
            // 
            toolStripVistasIconosPequenos.Name = "toolStripVistasIconosPequenos";
            toolStripVistasIconosPequenos.Size = new Size(180, 22);
            toolStripVistasIconosPequenos.Text = "Iconos Pequeños";
            toolStripVistasIconosPequenos.Click += toolStripVistasIconosPequenos_Click;
            // 
            // toolStripVistasLista
            // 
            toolStripVistasLista.Name = "toolStripVistasLista";
            toolStripVistasLista.Size = new Size(180, 22);
            toolStripVistasLista.Text = "Lista";
            toolStripVistasLista.Click += toolStripVistasLista_Click;
            // 
            // imgPequenos
            // 
            imgPequenos.ColorDepth = ColorDepth.Depth32Bit;
            imgPequenos.ImageStream = (ImageListStreamer)resources.GetObject("imgPequenos.ImageStream");
            imgPequenos.TransparentColor = Color.Transparent;
            imgPequenos.Images.SetKeyName(0, "dispositivo-de-disco-duro.png");
            imgPequenos.Images.SetKeyName(1, "carpeta-abierta.png");
            imgPequenos.Images.SetKeyName(2, "filas.png");
            // 
            // imgGrandes
            // 
            imgGrandes.ColorDepth = ColorDepth.Depth32Bit;
            imgGrandes.ImageStream = (ImageListStreamer)resources.GetObject("imgGrandes.ImageStream");
            imgGrandes.TransparentColor = Color.Transparent;
            imgGrandes.Images.SetKeyName(0, "dispositivo-de-disco-duro.png");
            imgGrandes.Images.SetKeyName(1, "carpeta-abierta.png");
            imgGrandes.Images.SetKeyName(2, "filas.png");
            // 
            // fmrInicial
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1112, 505);
            Controls.Add(toolStrip1);
            Controls.Add(lvArchivos);
            Controls.Add(trvArbol);
            Margin = new Padding(2);
            Name = "fmrInicial";
            Text = "Ficheros";
            Load += Form1_Load;
            toolStrip1.ResumeLayout(false);
            toolStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TreeView trvArbol;
        private ListView lvArchivos;
        private ToolStrip toolStrip1;
        private ToolStripSplitButton tsNuevo;
        private ToolStripSplitButton tsVistas;
        private ToolStripMenuItem toolStripVistasDetalles;
        private ToolStripMenuItem toolStripVistasIconosGrandes;
        private ToolStripMenuItem toolStripVistasIconosPequenos;
        private ToolStripMenuItem toolStripVistasLista;
        private ToolStripMenuItem carpetaToolStripNuevoCarpeta;
        private ToolStripMenuItem ficheroToolStripNuevoFichero;
        private ImageList imgPequenos;
        private ImageList imgGrandes;
    }
}
