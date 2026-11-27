namespace juego
{
    public partial class FrmBase : Form
    {
        private int direccion = 2;
        public FrmBase()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            switch (direccion)
            {
                case 1:
                    pcbBola.Top = pcbBola.Top - 2;
                    pcbBola.Left = pcbBola.Left + 2;
                    if (pcbBola.Top <= 0) direccion = 2; // choque techo
                    if (pcbBola.Left + pcbBola.Width >= ClientSize.Width) direccion = 4;
                    break;
                case 2:
                    pcbBola.Top = pcbBola.Top + 2;
                    pcbBola.Left = pcbBola.Left + 2;
                    if (pcbBola.Left + pcbBola.Width >= ClientSize.Width) direccion = 4;
                    if (pcbBola.Top + pcbBola.Height >= ClientSize.Height) direccion = 1;
                    break;
                case 3:
                    pcbBola.Top += 2;
                    pcbBola.Left -= 2;
                    break;
                case 4:
                    pcbBola.Top -= 2;
                    pcbBola.Left -= 2;
                    break;
            }
        }

        private void FrmBase_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.A) pcbBarra.Left = pcbBarra.Left - 10;
            if (e.KeyCode == Keys.D) pcbBarra.Left = pcbBarra.Left + 10;
        }
    }
}
