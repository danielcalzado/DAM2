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
            trvArbol = new TreeView();
            lvArchivos = new ListView();
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
            lvArchivos.Location = new Point(627, 130);
            lvArchivos.Name = "lvArchivos";
            lvArchivos.Size = new Size(422, 569);
            lvArchivos.TabIndex = 1;
            lvArchivos.UseCompatibleStateImageBehavior = false;
            // 
            // fmrInicial
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1589, 841);
            Controls.Add(lvArchivos);
            Controls.Add(trvArbol);
            Name = "fmrInicial";
            Text = "Ficheros";
            Load += Form1_Load;
            ResumeLayout(false);
        }

        #endregion

        private TreeView trvArbol;
        private ListView lvArchivos;
    }
}
