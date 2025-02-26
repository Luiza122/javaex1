public class Membro {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "👤 " + nome + " | ID: " + id + " | Email: " + email;
    }
}

