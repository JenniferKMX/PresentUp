package datos;

public class Usuario {

    private String nom;
    private String apes;
    private String email;
    private String password;
    private String pref;
    private String tlf;

    public String getNom() {
        return this.nom;
    }

    public String getApes() {
        return this.apes;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPref() {
        return this.pref;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setApes(String apes) {
        this.apes = apes;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

}