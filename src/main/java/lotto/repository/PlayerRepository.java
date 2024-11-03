package lotto.repository;

import lotto.domain.player.Player;

public class PlayerRepository {

    private Player player;

    public void createFrom(long money) {
        player = new Player(money);
    }

    public Player get() {
        return player;
    }
}
