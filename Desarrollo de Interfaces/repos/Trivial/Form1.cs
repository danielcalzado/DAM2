namespace Trivial
{
    public partial class Capitales : Form
    {
        // Campos
        private List<string> paises = new List<string>();
        private List<string> capitales = new List<string>();
        Label[] opciones;
        Random azar = new Random();

        // Estado de la partida
        private int aciertos = 0;
        private int preguntasHechas = 0;
        private int indiceActual;   // posición de la pregunta en curso

        // Constructor
        public Capitales()
        {
            InitializeComponent();
            CargarDatos();
            IniciarPartida();
        }

        // Eventos

        // Metodos propios
        private void AnadirPais(string pais, string capital)
        {
            paises.Add(pais);
            capitales.Add(capital);
        }

        private void CargarDatos()
        {
            AnadirPais("España", "Madrid");
            AnadirPais("Francia", "París");
            AnadirPais("Alemania", "Berlín");
            AnadirPais("Polonia", "Varsovia");
            AnadirPais("Bélgica", "Bruselas");
            AnadirPais("Países Bajos", "Amsterdam");
            AnadirPais("Rumanía", "Bucarest");
            AnadirPais("Grecia", "Atenas");
            AnadirPais("Noruega", "Oslo");
            AnadirPais("Dinamarca", "Copenhague");
            AnadirPais("Turquía", "Ankara");
            AnadirPais("Rusia", "Moscú");

        }

        private void NuevaPregunta()
        {
            indiceActual = azar.Next(paises.Count);
            lblPregunta.Text = paises[indiceActual];
            opciones = new Label[] { lblOpcion1, lblOpcion2, lblOpcion3, lblOpcion4 };
            int posicionCorrecta = azar.Next(4);
            List<int> usados = new List<int>();
            usados.Add(indiceActual);

            // Deshacer todo lo de la anterior pregunta
            for (int i = 0; i < opciones.Length; i++)
            {
                opciones[i].BackColor = SystemColors.ControlLightLight;
                opciones[i].Enabled = true;
            }
            lblResultado.Text = "";
            btnSiguiente.Enabled = false;

            for (int i = 0; i < 4; i++)
            {
                if (i == posicionCorrecta)
                {
                    opciones[i].Text = capitales[indiceActual];
                }
                else
                {
                    int candidato = azar.Next(paises.Count);

                    while (usados.Contains(candidato))
                    {
                        candidato = azar.Next(paises.Count);

                    }

                    usados.Add(candidato);
                    opciones[i].Text = capitales[candidato];

                }
            }
        }

        private void Opcion_Click(object sender, EventArgs e)
        {
            Label pulsado = (Label)sender; // cast para pasarlo de object a Label
            if (pulsado.Text == capitales[indiceActual])
            {
                lblResultado.Text = "¡Correcto!";
                pulsado.BackColor = Color.Lime;
                aciertos++;
                for (int i = 0; i < opciones.Length; i++)
                {
                    if (opciones[i] != pulsado)
                    {
                        opciones[i].Text = "";
                    }
                }
            }
            else
            {
                lblResultado.Text = "¡Incorrecto!";
                pulsado.BackColor = Color.Red;
                for (int i = 0; i < opciones.Length; i++)
                {
                    if (opciones[i].Text == capitales[indiceActual])
                    {
                        opciones[i].BackColor = Color.Lime;
                    }
                }
            }
            for (int i = 0; i < opciones.Length; i++)
            {
                opciones[i].Enabled = false;
            }
            preguntasHechas++;
            int porcentajeAciertos = (aciertos * 100) / preguntasHechas;
            lblPorcentaje.Text = Convert.ToString(porcentajeAciertos) + "%";
            btnSiguiente.Enabled = true;
        }

        private void btnSiguiente_Click(object sender, EventArgs e)
        {
            if (preguntasHechas >= 11)
            {
                lblPregunta.Text = "Has acertado " + aciertos + "/" + preguntasHechas;
                lblResultado.Text = "FINAL";
                btnSiguiente.Enabled = false;
                for (int i = 0; i < opciones.Length; i++)
                {
                    opciones[i].Text = "";
                    opciones[i].BackColor = SystemColors.ControlLightLight;
                }
            }
            else
            {
                NuevaPregunta();
            }
        }

        private void IniciarPartida()
        {
            aciertos = 0;
            preguntasHechas = 0;
            lblPorcentaje.Text = "0%";
            NuevaPregunta();
        }

        private void menuPartidaNueva_Click(object sender, EventArgs e)
        {
            IniciarPartida();
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}

