public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Adicionando livros
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "123456");
        Livro livro2 = new Livro("1984", "George Orwell", "654321");
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", "111222");
        Livro livro4 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "333444");
        Livro livro5 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "555666");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        // Registrando membros
        Membro membro1 = new Membro("Alice", 1, "alice@email.com");
        Membro membro2 = new Membro("Bob", 2, "bob@email.com");
        Membro membro3 = new Membro("Carlos", 3, "carlos@email.com");
        Membro membro4 = new Membro("Diana", 4, "diana@email.com");

        biblioteca.registrarMembro(membro1);
        biblioteca.registrarMembro(membro2);
        biblioteca.registrarMembro(membro3);
        biblioteca.registrarMembro(membro4);

        // Registrando múltiplos empréstimos
        biblioteca.registrarEmprestimo(1, "123456"); // Alice pega "O Senhor dos Anéis"
        biblioteca.registrarEmprestimo(2, "654321"); // Bob pega "1984"
        biblioteca.registrarEmprestimo(3, "111222"); // Carlos pega "Dom Quixote"
        biblioteca.registrarEmprestimo(4, "333444"); // Diana pega "Harry Potter"
        biblioteca.registrarEmprestimo(1, "555666"); // Alice pega "O Pequeno Príncipe"

        // Devolvendo alguns livros
        biblioteca.devolverLivro("123456"); // Alice devolve "O Senhor dos Anéis"
        biblioteca.devolverLivro("654321"); // Bob devolve "1984"

        // Removendo um livro que não está emprestado
        biblioteca.removerLivro("111222"); // Remover "Dom Quixote"
    }
}

