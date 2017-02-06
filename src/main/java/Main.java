import models.Client;
import models.Good;
import models.Order;
import models.ResourcesManager;

/**
 * Created by 33558 on 04.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ResourcesManager manager = new ResourcesManager();

        Client client = new Client();
        client.setNameClient("Some One");
        client.setAddressClient("Wherever");
        client.setPhoneClient("0933355844");

        manager.getDaoClient().addClientToDB(client);

        client = manager.getDaoClient().getClientByID(1);
        client.setNameClient("Updated Client");
        client.setAddressClient("new Updated address");
        client.setPhoneClient("0939339393");

        manager.getDaoClient().updateClient(client);
//        manager.getDaoClient().dellClient(manager.getDaoClient().getClientByID(2));

        Good good = new Good();
        good.setNameGood("Car");
        good.setDescriptionGood("VW touareg");
        good.setPriceGood(20000);

        manager.getDaoGoods().addGoodToDB(good);
        good = manager.getDaoGoods().getGoodByID(1);
        good.setNameGood("Name good updated");
        good.setDescriptionGood("new Description");
        good.setPriceGood(500.0);

        manager.getDaoGoods().updateGood(good);
//        manager.getDaoGoods().dellGood(manager.getDaoGoods().getGoodByID(2));

        Order order = new Order();
        order.setIdClient(client.getIdClient());
        order.setIdGoods(good.getIdGood());

        manager.getDaoOrder().addOrderToDB(order);
        order = manager.getDaoOrder().getOrderByID(1);
        order.setIdClient(manager.getDaoClient().getClientByID(3).getIdClient());
        order.setIdGoods(manager.getDaoGoods().getGoodByID(3).getIdGood());
        manager.getDaoOrder().updateOrder(order);
        manager.getDaoOrder().dellOrder(manager.getDaoOrder().getOrderByID(2));


        System.out.println(client.toString());
        System.out.println(good.toString());
        System.out.println(order.toString());
    }
}
