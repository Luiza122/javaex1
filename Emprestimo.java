import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Membro membro;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = new Date();
    }

    public Livro getLivro() {
        return livro;
    }

    public Membro getMembro() {
        return membro;
    }

    @Override
    public String toString() {
        return "📌 Empréstimo: Livro - " + livro.getTitulo() + " | Membro - " + membro.getId() + " | Data: " + dataEmprestimo;
    }
}
