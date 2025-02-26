import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Adicionar livro
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("✅ Livro adicionado: " + livro);
    }

    // Remover livro
    public void removerLivro(String isbn) {
        livros.removeIf(livro -> livro.getIsbn().equals(isbn));
        System.out.println("❌ Livro removido com ISBN: " + isbn);
    }

    // Registrar membro
    public void registrarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("✅ Membro registrado: " + membro);
    }

    // Registrar empréstimo
    public void registrarEmprestimo(int membroId, String isbn) {
        Membro membro = membros.stream().filter(m -> m.getId() == membroId).findFirst().orElse(null);
        Livro livro = livros.stream().filter(l -> l.getIsbn().equals(isbn)).findFirst().orElse(null);

        if (membro != null && livro != null) {
            emprestimos.add(new Emprestimo(livro, membro));
            System.out.println("📌 Empréstimo registrado: " + livro.getTitulo() + " → " + membro.getId());
        } else {
            System.out.println("⚠️ Membro ou livro não encontrado.");
        }
    }

    // Devolver livro
    public void devolverLivro(String isbn) {
        emprestimos.removeIf(emprestimo -> emprestimo.getLivro().getIsbn().equals(isbn));
        System.out.println("✅ Livro com ISBN " + isbn + " devolvido.");
    }
}
