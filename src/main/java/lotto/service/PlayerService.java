package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.List;

public class PlayerService {

    private static int LOTTO_PRICE = 1000;

    private final Player player;
    private final Lotto lotto;
    private final Bonus bonus;
    private final RandomNumberGenerator numberGenerator;

    public PlayerService(Player player, Lotto lotto, Bonus bonus) {
        this.player = player;
        this.lotto = lotto;
        this.bonus = bonus;
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

    public void calculateWinningCount(PlayerLotto playerLotto) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(lotto.getNumbers());
        for (Integer lottoNumber : playerLotto.getLottoNumbers()) {
            if (set.contains(lottoNumber)) {
                playerLotto.increaseWinningCount();
            }
        }

        if (playerLotto.getWinningCount() == 5){
           calculateBonusCount(playerLotto);
        }
    }

    private void calculateBonusCount(PlayerLotto playerLotto) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(playerLotto.getLottoNumbers());
        if (set.contains(bonus.getNumber())) {
            playerLotto.increaseBonusCount();
        }
    }
}
