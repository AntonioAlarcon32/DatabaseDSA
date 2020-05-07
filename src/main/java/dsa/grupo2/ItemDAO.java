package dsa.grupo2;

import dsa.grupo2.models.Item;

public interface ItemDAO {

    Item getItemById(String id);
    void addItem(Item i);
    Item getItemByName(String name);

}
