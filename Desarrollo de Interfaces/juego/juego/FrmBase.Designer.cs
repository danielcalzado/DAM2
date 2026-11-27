namespace juego
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
            components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmBase));
            pcbBola = new PictureBox();
            timer1 = new System.Windows.Forms.Timer(components);
            pcbBarra = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)pcbBola).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pcbBarra).BeginInit();
            SuspendLayout();
            // 
            // pcbBola
            // 
            pcbBola.Image = (Image)resources.GetObject("pcbBola.Image");
            pcbBola.Location = new Point(809, 458);
            pcbBola.Name = "pcbBola";
            pcbBola.Size = new Size(140, 167);
            pcbBola.SizeMode = PictureBoxSizeMode.StretchImage;
            pcbBola.TabIndex = 0;
            pcbBola.TabStop = false;
            // 
            // timer1
            // 
            timer1.Enabled = true;
            timer1.Interval = 1;
            timer1.Tick += timer1_Tick;
            // 
            // pcbBarra
            // 
            pcbBarra.Image = (Image)resources.GetObject("pcbBarra.Image");
            pcbBarra.Location = new Point(31, 54);
            pcbBarra.Name = "pcbBarra";
            pcbBarra.Size = new Size(604, 51);
            pcbBarra.SizeMode = PictureBoxSizeMode.StretchImage;
            pcbBarra.TabIndex = 1;
            pcbBarra.TabStop = false;
            // 
            // FrmBase
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1388, 802);
            ControlBox = false;
            Controls.Add(pcbBarra);
            Controls.Add(pcbBola);
            Name = "FrmBase";
            Text = "Arkanoid";
            KeyDown += FrmBase_KeyDown;
            ((System.ComponentModel.ISupportInitialize)pcbBola).EndInit();
            ((System.ComponentModel.ISupportInitialize)pcbBarra).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private PictureBox pcbBola;
        private System.Windows.Forms.Timer timer1;
        private PictureBox pcbBarra;
    }
}
