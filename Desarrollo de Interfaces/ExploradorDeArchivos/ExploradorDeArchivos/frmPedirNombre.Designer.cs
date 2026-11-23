namespace ExploradorDeArchivos
{
    partial class frmPedirNombre
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            lblIntroducirNombre = new Label();
            txtNombre = new TextBox();
            btnAceptar = new Button();
            btnCancelar = new Button();
            SuspendLayout();
            // 
            // lblIntroducirNombre
            // 
            lblIntroducirNombre.AutoSize = true;
            lblIntroducirNombre.Location = new Point(0, 0);
            lblIntroducirNombre.Name = "lblIntroducirNombre";
            lblIntroducirNombre.Size = new Size(121, 15);
            lblIntroducirNombre.TabIndex = 0;
            lblIntroducirNombre.Text = "Introduce el nombre: ";
            // 
            // txtNombre
            // 
            txtNombre.Location = new Point(1, 20);
            txtNombre.Name = "txtNombre";
            txtNombre.Size = new Size(100, 23);
            txtNombre.TabIndex = 1;
            // 
            // btnAceptar
            // 
            btnAceptar.DialogResult = DialogResult.OK;
            btnAceptar.Location = new Point(1, 49);
            btnAceptar.Name = "btnAceptar";
            btnAceptar.Size = new Size(75, 23);
            btnAceptar.TabIndex = 2;
            btnAceptar.Text = "Aceptar";
            btnAceptar.UseVisualStyleBackColor = true;
            // 
            // btnCancelar
            // 
            btnCancelar.DialogResult = DialogResult.Cancel;
            btnCancelar.Location = new Point(1, 78);
            btnCancelar.Name = "btnCancelar";
            btnCancelar.Size = new Size(75, 23);
            btnCancelar.TabIndex = 3;
            btnCancelar.Text = "Cancelar";
            btnCancelar.UseVisualStyleBackColor = true;
            // 
            // frmPedirNombre
            // 
            AcceptButton = btnAceptar;
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            CancelButton = btnCancelar;
            ClientSize = new Size(800, 450);
            Controls.Add(btnCancelar);
            Controls.Add(btnAceptar);
            Controls.Add(txtNombre);
            Controls.Add(lblIntroducirNombre);
            Name = "frmPedirNombre";
            Text = "Nombre";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblIntroducirNombre;
        private TextBox txtNombre;
        private Button btnAceptar;
        private Button btnCancelar;
    }
}