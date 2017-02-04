package models;

import dao.DaoClient;
import dao.DaoGoods;
import dao.DaoOrder;

import java.util.ArrayList;

/**
 * Created by 33558 on 04.02.2017.
 */
public class ResourcesManager {
    private DaoClient daoClient;
    private DaoGoods daoGoods;
    private DaoOrder daoOrder;
    private ArrayList<Client> clients;
    private ArrayList<Goods> goodsList;
    private ArrayList<Order> orders;

    public ResourcesManager() {
        this.daoClient = new DaoClient();
        this.daoGoods = new DaoGoods();
        this.daoOrder = new DaoOrder();
        this.clients = new ArrayList<>();
        this.goodsList = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public DaoClient getDaoClient() {
        return daoClient;
    }

    public void setDaoClient(DaoClient daoClient) {
        this.daoClient = daoClient;
    }

    public DaoGoods getDaoGoods() {
        return daoGoods;
    }

    public void setDaoGoods(DaoGoods daoGoods) {
        this.daoGoods = daoGoods;
    }

    public DaoOrder getDaoOrder() {
        return daoOrder;
    }

    public void setDaoOrder(DaoOrder daoOrder) {
        this.daoOrder = daoOrder;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
