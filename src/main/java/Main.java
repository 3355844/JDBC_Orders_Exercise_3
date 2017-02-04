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

        Good good = new Good();
        good.setNameGood("Car");
        good.setDescriptionGood("VW touareg");
        good.setPriceGood(20000);

        manager.getDaoGoods().addGoodToDB(good);
        good = manager.getDaoGoods().getGoodByID(1);

        Order order = new Order();
        order.setIdClient(client.getIdClient());
        order.setIdGoods(good.getIdGood());

        manager.getDaoOrder().addOrderToDB(order);
        order = manager.getDaoOrder().getOrderByID(1);

        System.out.println(client.toString());
        System.out.println(good.toString());
        System.out.println(order.toString());
    }
}
