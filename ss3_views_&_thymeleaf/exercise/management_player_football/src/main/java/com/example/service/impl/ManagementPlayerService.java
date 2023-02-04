package com.example.service.impl;

import com.example.model.Player;
import com.example.service.IManagementPlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagementPlayerService implements IManagementPlayerService {
    private static final Map<Integer, Player> players;

    static {
        players = new HashMap<>();
        players.put(1, new Player(1, "Nguyễn Văn Thành", "15/02/1997", "Tiền đạo", "2 năm"));
        players.put(2, new Player(2, "Nguyễn Văn Huy", "20/02/1999", "Hậu vệ", "2 năm"));
        players.put(3, new Player(3, "Nguyễn Thiện Phúc", "10/02/1999", "Tiền đạo", "1 năm"));
        players.put(4, new Player(4, "Lê Thanh Tuấn", "30/11/1999", "Tiền đạo", "3 năm"));
        players.put(5, new Player(5, "Trần Ba Tài", "22/02/2004", "Tiền đạo", "1 năm"));
        players.put(6, new Player(6, "Nguyễn Trương Công Định", "30/12/1999", "Tiền đạo", "4 năm"));
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(players.values());
    }

    @Override
    public void save(Player player) {
        players.put(player.getId(), player);
    }

    @Override
    public Player findById(int id) {
        return players.get(id);
    }

    @Override
    public void remove(int id) {
        players.remove(id);
    }
}