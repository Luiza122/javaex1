import java.io.IOException;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", "11111");
        Livro livro2 = new Livro("O Hobbit", "J.R.R. Tolkien", "22222");

        Membro membro1 = new Membro("Alice", 1, "alice@email.com");
        Membro membro2 = new Membro("Carlos", 2, "carlos@email.com");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.registrarMembro(membro1);
        biblioteca.registrarMembro(membro2);

        biblioteca.registrarEmprestimo("11111", 1);

        try {
            biblioteca.salvarDados("biblioteca.dat");
            biblioteca.carregarDados("biblioteca.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        biblioteca.devolverLivro("11111", 1);
        biblioteca.listarEmprestimos();
    }
}

