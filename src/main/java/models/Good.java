package models;

/**
 * Created by 33558 on 04.02.2017.
 */
public class Good {
    private int idGood;
    private String nameGood;
    private String descriptionGood;
    private double priceGood;

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    public String getDescriptionGood() {
        return descriptionGood;
    }

    public void setDescriptionGood(String descriptionGood) {
        this.descriptionGood = descriptionGood;
    }

    public double getPriceGood() {
        return priceGood;
    }

    public void setPriceGood(double priceGood) {
        this.priceGood = priceGood;
    }

    @Override
    public String toString() {
        return "Good{" +
                "idGood=" + idGood +
                ", nameGood='" + nameGood + '\'' +
                ", descriptionGood='" + descriptionGood + '\'' +
                ", priceGood=" + priceGood +
                '}';
    }
}
