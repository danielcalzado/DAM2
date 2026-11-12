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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(fmrInicial));
            trvArbol = new TreeView();
            lvArchivos = new ListView();
            toolStrip1 = new ToolStrip();
            tsNuevo = new ToolStripSplitButton();
            tsVistas = new ToolStripSplitButton();
            toolStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // trvArbol
            // 
            trvArbol.Location = new Point(103, 130);
            trvArbol.Name = "trvArbol";
            trvArbol.Size = new Size(392, 569);
            trvArbol.TabIndex = 0;
            trvArbol.AfterSelect += trvArbol_AfterSelect;
            // 
            // lvArchivos
            // 
            lvArchivos.FullRowSelect = true;
            lvArchivos.Location = new Point(627, 130);
            lvArchivos.Name = "lvArchivos";
            lvArchivos.Size = new Size(422, 569);
            lvArchivos.TabIndex = 1;
            lvArchivos.UseCompatibleStateImageBehavior = false;
            lvArchivos.View = View.Details;
            // 
            // toolStrip1
            // 
            toolStrip1.ImageScalingSize = new Size(24, 24);
            toolStrip1.Items.AddRange(new ToolStripItem[] { tsNuevo, tsVistas });
            toolStrip1.Location = new Point(0, 0);
            toolStrip1.Name = "toolStrip1";
            toolStrip1.Size = new Size(1589, 58);
            toolStrip1.TabIndex = 2;
            toolStrip1.Text = "toolStrip1";
            // 
            // tsNuevo
            // 
            tsNuevo.Image = (Image)resources.GetObject("tsNuevo.Image");
            tsNuevo.ImageTransparentColor = Color.Magenta;
            tsNuevo.Name = "tsNuevo";
            tsNuevo.Size = new Size(85, 53);
            tsNuevo.Text = "Nuevo";
            tsNuevo.TextDirection = ToolStripTextDirection.Horizontal;
            tsNuevo.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // tsVistas
            // 
            tsVistas.Image = (Image)resources.GetObject("tsVistas.Image");
            tsVistas.ImageTransparentColor = Color.Magenta;
            tsVistas.Name = "tsVistas";
            tsVistas.Size = new Size(79, 53);
            tsVistas.Text = "Vistas";
            tsVistas.TextImageRelation = TextImageRelation.ImageAboveText;
            // 
            // fmrInicial
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1589, 841);
            Controls.Add(toolStrip1);
            Controls.Add(lvArchivos);
            Controls.Add(trvArbol);
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
    }
}
