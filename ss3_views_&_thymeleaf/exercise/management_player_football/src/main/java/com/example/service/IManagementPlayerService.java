package com.example.service;

import com.example.model.Player;

import java.util.List;

public interface IManagementPlayerService {
    List<Player> findAll();

    void save(Player player);

    Player findById(int id);

    void remove(int id);
}