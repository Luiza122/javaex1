import java.io.*;
import java.util.*;

class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Membro> membros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        if (buscarLivro(livro.getIsbn()) != null) {
            System.out.println("Livro já cadastrado.");
            return;
        }
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro);
    }

    public void removerLivro(String isbn) {
        Livro livro = buscarLivro(isbn);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (livro.isEmprestado()) {
            System.out.println("Livro está emprestado e não pode ser removido.");
            return;
        }
        livros.remove(livro);
        System.out.println("Livro removido: " + livro);
    }

    public Livro buscarLivro(String isbn) {
        return livros.stream().filter(l -> l.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public void registrarMembro(Membro membro) {
        if (buscarMembro(membro.getId()) != null) {
            System.out.println("Membro já registrado.");
            return;
        }
        membros.add(membro);
        System.out.println("Membro registrado: " + membro);
    }

    public Membro buscarMembro(int id) {
        return membros.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public void registrarEmprestimo(String isbn, int membroId) {
        Livro livro = buscarLivro(isbn);
        Membro membro = buscarMembro(membroId);

        if (livro == null || membro == null) {
            System.out.println("Livro ou membro não encontrado.");
            return;
        }
        if (livro.isEmprestado()) {
            System.out.println("Livro já está emprestado.");
            return;
        }
        emprestimos.add(new Emprestimo(livro, membro));
        System.out.println("Empréstimo realizado: " + livro.getTitulo() + " para " + membro.getNome());
    }

    public void devolverLivro(String isbn, int membroId) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getLivro().getIsbn().equals(isbn) && e.getMembro().getId() == membroId)
                .findFirst()
                .orElse(null);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }
        emprestimos.remove(emprestimo);
        emprestimo.getLivro().devolver();
        System.out.println("Livro devolvido: " + emprestimo.getLivro().getTitulo());
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        emprestimos.forEach(System.out::println);
    }

    public void salvarDados(String arquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(livros);
            out.writeObject(membros);
            out.writeObject(emprestimos);
            System.out.println("Dados salvos com sucesso.");
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados(String arquivo) throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            livros = (List<Livro>) in.readObject();
            membros = (List<Membro>) in.readObject();
            emprestimos = (List<Emprestimo>) in.readObject();
            System.out.println("Dados carregados com sucesso.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
