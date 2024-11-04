package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            int amount = lottoGame.getPurchaseAmount();
            List<Lotto> lottos = lottoGame.generateLottos(amount);
            System.out.println(amount / 1000 + "개를 구매했습니다.");
            lottos.forEach(System.out::println);

            List<Integer> winningNumbers = lottoGame.getWinningNumbers();
            int bonusNumber = lottoGame.getBonusNumber(winningNumbers);
            LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);

            LottoStatistics statistics = new LottoStatistics();
            for (Lotto lotto : lottos) {
                LottoRank rank = lottoResult.getLottoRank(lotto);
                statistics.addResult(rank);
            }

            statistics.printStatistics(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
