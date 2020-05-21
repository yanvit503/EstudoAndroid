using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EstudoAPI.Model
{
    public class Funcionario
    {
        public int FuncionarioId { get; set; }
        public string Nome { get; set; }
        public string Cargo { get; set; }
        public DateTime Nascimento { get; set; }
        public bool Ativo { get; set; }
        public string Imagem { get; set; }

    }
}
