package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;

    public static Lottos showPurchasedLottos(long userPrice) {

        long purchasedLottoCount = userPrice / LOTTO_PRICE;
        System.out.println(purchasedLottoCount + "개를 구매했습니다.");

        Lottos lottos = Lottos.createLottos(new ArrayList<>());
        for (int i = 0; i < purchasedLottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = Lotto.createLotto(numbers);
            System.out.println(lotto.printLotto());
            lottos.addLotto(lotto);
        }
        System.out.println();

        return lottos;
    }

    public static void showPurchasedLottosStatus(LottoWinningNumbers lottoWinningNumbers, Lottos lottos, long userPurchaseMoney) {

        System.out.println("당첨 통계");
        String hyphen = "-";
        System.out.println(hyphen.repeat(3));

        long profit = 0;
        int[] lottoResultCounts = new int[7];
        for (Lotto lotto : lottos.getLottos()) {
            LottoResult lottoResult = lotto.calculatePrize(lottoWinningNumbers);
            profit += lottoResult.getPrice();
            lottoResultCounts[lottoResult.getRank()]++;
        }

        System.out.println(LottoResult.FIFTH_PRIZE.getDescription() + " - " + lottoResultCounts[5] + "개");
        System.out.println(LottoResult.FOURTH_PRIZE.getDescription() + " - " + lottoResultCounts[4] + "개");
        System.out.println(LottoResult.THIRD_PRIZE.getDescription() + " - " + lottoResultCounts[3] + "개");
        System.out.println(LottoResult.SECOND_PRIZE.getDescription() + " - " + lottoResultCounts[2] + "개");
        System.out.println(LottoResult.FIRST_PRIZE.getDescription() + " - " + lottoResultCounts[1] + "개");

        double yield = (double) profit / userPurchaseMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
