package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int lottoCount;
        List<Lotto> lottos = new ArrayList<>();
        int totalPrice = 0;

        // 로또 구매
        int amount = InputHandler.getPurchaseAmount();
        lottoCount = amount / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = RandomMaker.generateLottoNumbers(NUMBER_COUNT);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        OutputHandler.displayPurchasedLottos(lottos);

        WinningNumbers winningNumbers = InputHandler.getWinningNumbers();

        // EnumMap으로 등수 갯수 계산
        Map<Rank, Integer> rankCountMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = LottoChecker.check(lotto, winningNumbers);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
            totalPrice += rank.getPrize();
        }

        // 결과 출력
        double profitRate = (double) totalPrice / amount * 100;
        OutputHandler.displayResults(rankCountMap, profitRate);
    }
}
