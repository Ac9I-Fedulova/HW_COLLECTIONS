package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void whenFirstPlayerWin() {    // первый сильнее
        Player anya = new Player(22, "Аня", 550);
        Player vanya = new Player(114, "Ваня", 100);

        game.register(vanya);
        game.register(anya);

        int actual = game.round("Аня", "Ваня");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerWin() {  // второй сильнее
        Player anya = new Player(22, "Аня", 550);
        Player vanya = new Player(114, "Ваня", 100);

        game.register(vanya);
        game.register(anya);

        int actual = game.round("Ваня", "Аня");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenNoOneWins() {    // ничья
        Player anya = new Player(22, "Аня", 100);
        Player vanya = new Player(114, "Ваня", 100);

        game.register(vanya);
        game.register(anya);

        int actual = game.round("Ваня", "Аня");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenOnlySecondPlayerIsRegistered() {    // зарегистрировать только второй игрок
        Player anya = new Player(22, "Аня", 100);
        Player kolya = new Player(55, "Коля", 120);

        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Аня");
        });
    }

    @Test
    public void whenOnlyFirstPlayerIsRegistered() {    // зарегистрировать только первый игрок
        Player anya = new Player(22, "Аня", 100);
        Player kolya = new Player(55, "Коля", 120);

        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Аня", "Коля");
        });
    }


}




