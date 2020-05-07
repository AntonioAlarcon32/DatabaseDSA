package dsa.grupo2;

import dsa.grupo2.models.Item;
import dsa.grupo2.models.User;

public class ItemDAOImp implements ItemDAO {

    @Override
    public Item getItemById(String id) {
        Session session = null;
        Item item = new Item();
        try {
            session = FactorySession.openSession();
            item = (Item) session.get(Item.class,"id", id);
        }
        catch (Exception e) {

        }
        finally {
            session.close();
        }
        return item;    }

    @Override
    public void addItem(Item i) {

    }

    @Override
    public Item getItemByName(String name) {
        return null;
    }
}
