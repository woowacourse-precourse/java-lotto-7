package lotto.service;

import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.util.RandomNumberGenerator;

import java.util.List;

public class LottoService {

    private static int LOTTO_PRICE = 1000;

    private Player player;
    private final RandomNumberGenerator numberGenerator;

    public LottoService(Player player) {
        this.player = player;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void updateLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        player.updateLottoCount(lottoCount);
    }

    public void addLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            player.addLotto(createLotto());
        }
    }

    private PlayerLotto createLotto() {
        List<Integer> lottoNumbers = numberGenerator.generateLottoNumbers();
        return new PlayerLotto(lottoNumbers);
    }
}
