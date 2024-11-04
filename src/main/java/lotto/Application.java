package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        // 로또 구매
        int amount = InputHandler.getPurchaseAmount();
        int lottoCount = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomMaker.generateLottoNumbers(NUMBER_COUNT)));
        }

        OutputHandler.displayPurchasedLottos(lottos);

        WinningNumbers winningNumbers = InputHandler.getWinningNumbers();

        // EnumMap으로 등수 갯수 계산
        Map<Rank, Integer> rankCounts = ResultCalculator.calculateResults(lottos, winningNumbers);
        int totalPrice = ResultCalculator.calculateTotalPrize(rankCounts);
        double profitRate = (double) totalPrice / amount * 100;

        // 출력
        OutputHandler.displayResults(rankCounts, profitRate);
    }
}
