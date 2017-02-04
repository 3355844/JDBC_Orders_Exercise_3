package models;

/**
 * Created by 33558 on 04.02.2017.
 */
public class Goods {
    private int idGoods;
    private String nameGoods;
    private String descriptionGoods;
    private double priceGoods;

    public int getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(int idGoods) {
        this.idGoods = idGoods;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public String getDescriptionGoods() {
        return descriptionGoods;
    }

    public void setDescriptionGoods(String descriptionGoods) {
        this.descriptionGoods = descriptionGoods;
    }

    public double getPriceGoods() {
        return priceGoods;
    }

    public void setPriceGoods(double priceGoods) {
        this.priceGoods = priceGoods;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "idGoods=" + idGoods +
                ", nameGoods='" + nameGoods + '\'' +
                ", descriptionGoods='" + descriptionGoods + '\'' +
                ", priceGoods=" + priceGoods +
                '}';
    }
}
