using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExploradorDeArchivos
{
    public partial class frmVisorTexto : Form
    {
        public frmVisorTexto(string rutaFichero)
        {
            InitializeComponent();

            // Ponemos el nombre del archivo en la barra de título de la ventana
            this.Text = Path.GetFileName(rutaFichero);

            // Leemos todo el texto del archivo y lo volcamos al TextBox
            txtContenido.Text = File.ReadAllText(rutaFichero);
        }
    }
}
