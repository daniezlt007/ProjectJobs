package projectjobs.app.com.br.model;

public class Candidates {

    private String id;
    private String email;
    private String nome;
    private String experiencia;
    private String resumo;

    public Candidates() {

    }

    public Candidates(String id, String email, String nome, String experiencia, String resumo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.experiencia = experiencia;
        this.resumo = resumo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
