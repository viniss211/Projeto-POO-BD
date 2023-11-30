package Model;

public class Emprestimo {
    private int id;
    private String dataAluga;
    private String dataDevolve;
    private int temMulta;
    private float valorMulta;



    public void setId(int id) {
        this.id = id;
    }

    public void setDataAluga(String dataAluga) {
        this.dataAluga = dataAluga;
    }

    public void setDataDevolve(String dataDevolve) {
        this.dataDevolve = dataDevolve;
    }

    public void setTemMulta(int temMulta) {
        this.temMulta = temMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }


    public String getDataAluga() {
        return dataAluga;
    }

    public String getDataDevolve() {
        return dataDevolve;
    }


    public int getTemMulta() {
        return temMulta;
    }

    public float getValorMulta() {
        return valorMulta;
    }
}
