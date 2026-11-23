using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjercicioRepaso
{
    public class Producto
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public int Stock { get; set; }
        public string Categoria { get; set; }

        public Producto (int id, string nombre, int stock, string categoria)
        {
            Id = id;
            Nombre = nombre;
            Stock = stock;
            Categoria = categoria;
        }
    }
}
