package dao;

/**
 * Created by 33558 on 04.02.2017.
 */
public class DaoManager {

    private DaoClient daoClient;
    private DaoGoods daoGoods;
    private DaoOrder daoOrder;

    public DaoManager() {
        this.daoClient = new ClientDaoJdbcImpl();
        this.daoGoods = new GoodsDaoJdbcImpl();
        this.daoOrder = new OrderDaoJdbcImpl();
    }

    public DaoClient getDaoClient() {
        return daoClient;
    }

    public DaoGoods getDaoGoods() {
        return daoGoods;
    }

    public DaoOrder getDaoOrder() {
        return daoOrder;
    }
}
