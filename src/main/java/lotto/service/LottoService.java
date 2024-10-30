package lotto.service;

import lotto.domain.player.Player;

public class LottoService {

    private static int LOTTO_PRICE = 1000;

    private Player player;

    public LottoService(Player player) {
        this.player = player;
    }

    public void updateLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        player.updateLottoCount(lottoCount);
    }

    public void createLottos(int lottoCount) {

    }
}
