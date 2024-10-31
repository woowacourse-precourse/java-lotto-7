package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerResult;
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

    // 1. 구매할 수 있는 로또의 개수
    public int updateLottoCount(int price) {
        int lottoCount = price / LOTTO_PRICE;
        player.updateLottoCount(lottoCount);
        return lottoCount;
    }

    // 2. 구매할 수 있는 개수만큼 로또를 생성하는 기능
    public void addLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            player.addLotto(createLotto());
        }
    }

    private PlayerLotto createLotto() {
        List<Integer> lottoNumbers = numberGenerator.generateLottoNumbers();
        return new PlayerLotto(lottoNumbers);
    }

    // 5. 로또 당첨 여부를 판단하는 기능
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

    // 6. 수익률을 계산하는 기능
    public void updatePlayerResult(Player player) {

    }

    public void calculateWinningRank(List<PlayerLotto> playerLottos) {

    }

    public int calculateProfit(PlayerResult playerResult) {
        return 0;
    }

    public float calculateProfitRate(int price, long profit) {
        return 0;
    }
}
