package lotto.repository;

import java.util.List;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.random.LottoRandom;

public class PlayerRepository {

    private Player player;

    public void create(long money) {
        player = new Player(money);
    }

    public List<Lotto> buyLottos(LottoRandom lottoRandom) {
        player.buyLottoTickets(lottoRandom);
        return player.getLottos();
    }

    public Player get() {
        return player;
    }
}
