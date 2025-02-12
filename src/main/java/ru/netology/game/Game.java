package ru.netology.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player searchPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = searchPlayer(playerName1);
        Player player2 = searchPlayer(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1; // Победил первый игрок
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2; // Победил второй игрок
        } else {
            return 0; // Ничья
        }
    }
}
