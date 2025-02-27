import java.io.Serializable;

class Membro implements Serializable {
    private String nome;
    private int id;
    private String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() { return nome; }
    public int getId() { return id; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nome + " (ID: " + id + ", Email: " + email + ")";
    }
}
