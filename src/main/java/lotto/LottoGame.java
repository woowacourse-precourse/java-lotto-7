package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final WinningResult winningResult;
    private final int purchaseAmount;

    public LottoGame(int money) {
        this.purchaseAmount = money;
        this.lottos = new ArrayList<>();
        this.winningResult = new WinningResult();
        buyLottos(money);
    }

    private void buyLottos(int money) {
        int lottoCount = money / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.generate());
        }
    }

    public void printLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void checkWinningLottos(Lotto winningLotto, int bonusNumber) {
        for (Lotto lotto : lottos) {
            LottoRank rank = LottoRank.getRank(lotto, winningLotto, bonusNumber);
            winningResult.addWinningRank(rank);
        }
    }

    public void printWinningStatistics() {
        winningResult.printStatistics();
        double returnRate = winningResult.calculateReturnRate(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}