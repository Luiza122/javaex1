import java.io.Serializable;
import java.util.Date;

class Emprestimo implements Serializable {
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = new Date();
        livro.emprestar();
    }

    public Livro getLivro() { return livro; }
    public Membro getMembro() { return membro; }
    public Date getDataEmprestimo() { return dataEmprestimo; }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + " | Membro: " + membro.getNome() +
                " | Data: " + dataEmprestimo;
    }
}
