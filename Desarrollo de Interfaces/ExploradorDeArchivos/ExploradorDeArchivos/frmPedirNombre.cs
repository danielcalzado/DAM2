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
    public partial class frmPedirNombre : Form
    {
        // Propiedad pública para que fmrInicial pueda leer lo que escribió el usuario
        public string NombreIntroducido
        {
            get { return txtNombre.Text.Trim(); }
        }
        public frmPedirNombre()
        {
            InitializeComponent();
        }
    }
}
