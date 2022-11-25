package com.example.miniproject;

import java.util.HashMap;

public class ItemDAO {

    HashMap<Integer, ItemDTO> map;

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

    public ItemDTO orderItem(int id) {
        if (map.get(id) == null || map.get(id).getQty() == 0) {
            return null;
        }
        map.get(id).setQty();
    }

}
