package com.example.miniproject;

import android.util.Log;

import java.util.HashMap;

public class ItemDAO {

    HashMap<Integer, ItemDTO> map;

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
    }

}
