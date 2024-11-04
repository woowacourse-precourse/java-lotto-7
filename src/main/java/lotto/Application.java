package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoProfitCalculator;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            LottoInputView inputView = new LottoInputView();
            LottoOutputView outputView = new LottoOutputView();

            System.out.println("구입금액을 입력해 주세요.");
            int money = inputView.readMoney();

            List<Lotto> lottos = new ArrayList<>();
            int count = money / LOTTO_PRICE;
            System.out.println(outputView.getLottoCountMessage(count));

            for (int i = 0; i < count; i++) {
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                lottos.add(new Lotto(numbers));
                System.out.println(outputView.getLottoNumbersMessage(numbers));
            }

            System.out.println("\n당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = inputView.readWinningNumbers();

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = inputView.readBonusNumber(winningNumbers);

            LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
            LottoProfitCalculator profitCalculator = new LottoProfitCalculator(money);

            System.out.println(outputView.getWinningStatisticsHeader());

            int[] prizeCount = new int[6];
            for (Lotto lotto : lottos) {
                int rank = lottoResult.getRank(lotto.getNumbers());
                if (rank > 0) {
                    prizeCount[rank]++;
                    profitCalculator.addPrize(lottoResult.getPrize(lotto.getNumbers()));
                }
            }
            System.out.println(outputView.getWinningResultMessage(3, 5000, prizeCount[5]));
            System.out.println(outputView.getWinningResultMessage(4, 50000, prizeCount[4]));
            System.out.println(outputView.getWinningResultMessage(5, 1500000, prizeCount[3]));
            System.out.println(outputView.getWinningResultMessage(5, 30000000, prizeCount[2]));
            System.out.println(outputView.getWinningResultMessage(6, 2000000000, prizeCount[1]));
            System.out.println(outputView.getProfitRateMessage(profitCalculator.getProfitRate()));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
