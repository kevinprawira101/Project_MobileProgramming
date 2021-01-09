package com.example.binusezyfood;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static List<OrderList> orderlist = new ArrayList<OrderList>();
    private static int nextId = 0;
    public static int total;

    public MyApplication() {

    }

    public static List<OrderList> getOrderlist() {
        return orderlist;
    }

    public static void setOrderlist(List<OrderList> orderlist) {
        MyApplication.orderlist = orderlist;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }

}
