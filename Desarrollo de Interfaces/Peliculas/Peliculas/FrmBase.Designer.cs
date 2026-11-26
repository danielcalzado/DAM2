namespace Peliculas
{
    partial class FrmBase
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
            lstTitulos = new ListBox();
            lstActores = new ListBox();
            lstDirectores = new ListBox();
            SuspendLayout();
            // 
            // lstTitulos
            // 
            lstTitulos.FormattingEnabled = true;
            lstTitulos.ItemHeight = 25;
            lstTitulos.Location = new Point(460, 166);
            lstTitulos.Name = "lstTitulos";
            lstTitulos.Size = new Size(645, 154);
            lstTitulos.TabIndex = 0;
            // 
            // lstActores
            // 
            lstActores.FormattingEnabled = true;
            lstActores.ItemHeight = 25;
            lstActores.Location = new Point(460, 349);
            lstActores.Name = "lstActores";
            lstActores.Size = new Size(645, 154);
            lstActores.TabIndex = 1;
            // 
            // lstDirectores
            // 
            lstDirectores.FormattingEnabled = true;
            lstDirectores.ItemHeight = 25;
            lstDirectores.Location = new Point(460, 528);
            lstDirectores.Name = "lstDirectores";
            lstDirectores.Size = new Size(645, 154);
            lstDirectores.TabIndex = 2;
            // 
            // FrmBase
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1148, 877);
            Controls.Add(lstDirectores);
            Controls.Add(lstActores);
            Controls.Add(lstTitulos);
            Name = "FrmBase";
            Text = "Peliculas";
            Load += FrmBase_Load;
            ResumeLayout(false);
        }

        #endregion

        private ListBox lstTitulos;
        private ListBox lstActores;
        private ListBox lstDirectores;
    }
}
