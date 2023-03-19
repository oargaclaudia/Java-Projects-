package org.example.domain;
public class Bursa extends Entity<Long> {
    private long id;
    private String nume;
    private String prenume;
    private String tip;
    private double suma;

    public Bursa(Long id, String nume, String prenume, String tip, Double suma) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.tip = tip;
        this.suma = suma;
    }

    public Bursa() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {return prenume;}

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Bursa{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", tip='" + tip + '\'' +
                ", suma=" + suma +
                '}';
    }
}