import models.Client;
import models.Good;
import models.Order;
import dao.DaoManager;

/**
 * Created by 33558 on 04.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        DaoManager manager = new DaoManager();

        Client client = new Client();
        client.setNameClient("Some One");
        client.setAddressClient("Wherever");
        client.setPhoneClient("0933355844");

        manager.getDaoClient().add(client);

        client = manager.getDaoClient().getById(3);
        client.setNameClient("Updated Client");
        client.setAddressClient("new Updated address");
        client.setPhoneClient("0939339393");

        manager.getDaoClient().update(client);

        Good good = new Good();
        good.setNameGood("Car");
        good.setDescriptionGood("VW touareg");
        good.setPriceGood(20000);

        manager.getDaoGoods().add(good);
        good = manager.getDaoGoods().getById(5);
        good.setNameGood("Name good updated");
        good.setDescriptionGood("new Description");
        good.setPriceGood(500.0);

        manager.getDaoGoods().update(good);

        Order order = new Order();
        order.setIdClient(client.getIdClient());
        order.setIdGoods(good.getIdGood());

        manager.getDaoOrder().add(order);
        order = manager.getDaoOrder().getById(1);
        order.setIdClient(((Client) manager.getDaoClient().getById(4)).getIdClient());
        order.setIdGoods(((Good) manager.getDaoGoods().getById(4)).getIdGood());
        manager.getDaoOrder().update(order);

        System.out.println(client.toString());
        System.out.println(good.toString());
        System.out.println(order.toString());
    }
}
