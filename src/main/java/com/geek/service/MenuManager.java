package com.geek.service;

import com.geek.model.Menu;

import java.util.List;

public interface MenuManager {

    List<Menu> getAllMenus();

    List<Menu> getMenusByMidCid(String mid, String cid);

    Menu getMenuByMid(String mid);

    int addMenu(int cid, String mname, float price);

    int updateMenuByMid(int mid, int cid, String mname, float price);

    int deleteMenuByMid(int mid);

}
