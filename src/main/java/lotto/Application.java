package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Application {

    private static int userPrice = 1000;

    public static void main(String[] args) {

        long lottoPrice = InputView.inputPurchaseMoney();

        long purchasedLottoCount = userPrice / lottoPrice;
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

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber(winningNumbers);


        System.out.println("당첨 통계");
        String hyphen = "-";
        System.out.println(hyphen.repeat(3));
        winningNumbers.remove(bonusNumber);

        long profit = 0;
        int[] lottoResultCounts = new int[7];
        for (Lotto lotto : lottos.getLottos()) {
            LottoResult lottoResult = lotto.calculatePrize(winningNumbers, bonusNumber);
            profit += lottoResult.getPrice();
            lottoResultCounts[lottoResult.getRank()]++;
        }

        System.out.println(LottoResult.FIFTH_PRIZE.getDescription() + " - " + lottoResultCounts[5] + "개");
        System.out.println(LottoResult.FOURTH_PRIZE.getDescription() + " - " + lottoResultCounts[4] + "개");
        System.out.println(LottoResult.THIRD_PRIZE.getDescription() + " - " + lottoResultCounts[3] + "개");
        System.out.println(LottoResult.SECOND_PRIZE.getDescription() + " - " + lottoResultCounts[2] + "개");
        System.out.println(LottoResult.FIRST_PRIZE.getDescription() + " - " + lottoResultCounts[1] + "개");

        double yield = (double) profit / userPrice * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
