package com.example.miniproject;

<<<<<<< HEAD
=======
import android.util.Log;

>>>>>>> Mini_JB
import java.util.HashMap;

public class ItemDAO {

    HashMap<Integer, ItemDTO> map;

<<<<<<< HEAD
    public ItemDAO() {
        map = new HashMap<>();
        map.put(1, new ItemDTO(1, "콜라", 1000, 10));
        map.put(2, new ItemDTO(2, "펩시", 800, 7));
        map.put(3, new ItemDTO(3, "스프라이트", 700, 0));
        map.put(4, new ItemDTO(4, "웰치스", 900, 8));
    }

    public HashMap<Integer, ItemDTO> getItem() {
        return map;
    }

    public void orderItem(int id) {
        ItemDTO dto = map.get(id);
        dto.setQty(dto.getQty() - 1);
=======
    //음료객체
    public ItemDAO() {
        map = new HashMap<>();
        map.put(1, new ItemDTO(1,1000,10,"코카콜라"));
        map.put(2, new ItemDTO(2,800,10,"펩시콜라"));
        map.put(3, new ItemDTO(3,700,10,"코카콜라"));
        map.put(4, new ItemDTO(4,800,10,"코카콜라"));
    }

    //음료 주문
    public int item_order(int qty) {
        if (qty == 0) {
            return qty;
        } else {
            return qty - 1;
        }
    }
    
    //구매
    public int charge(int money, int price) {
        if (money < price) {
            return money;
        } else {
            return money - price;
        }
>>>>>>> Mini_JB
    }

}
