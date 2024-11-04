package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningInformation;
import lotto.domain.WinningPrize;

public class OutputView {

    public static final String AFTER_BUYING_MESSAGE = "개를 구매했습니다.";
    public static final String START_STATISTICS_MESSAGE = "당첨 통계";
    public static final String START_RETURN_OF_RATE_MESSAGE = "총 수익률은 ";
    public static final String END_RETURN_OF_RATE_MESSAGE = "%입니다.";
    public static final String DIVIDER = "---";
    public static final String NEWLINE = "\n";

    public void printLottoNumber(List<Lotto> lottos, int purchaseAmount) {
        System.out.println(NEWLINE + purchaseAmount + AFTER_BUYING_MESSAGE);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }

        System.out.println();
    }

    // prizeAndCount의 첫 번째 값은 낙첨된 경우에 대한 정보이기 때문에 건너뛰고 출력하였다.
    public void printWinningInformation() {
        Map<WinningPrize, Integer> prizeAndCount = WinningInformation.getInstance().getPrizeAndCount();
        System.out.println(NEWLINE + START_STATISTICS_MESSAGE);
        System.out.println(DIVIDER);

        prizeAndCount.entrySet().stream()
                .skip(1)
                .forEach(entry ->
                        System.out.println(
                                entry.getKey().getMatchCount() + " (" + entry.getKey().getFormattedPrize() + "원) - "
                                        + entry.getValue() + "개")
                );
    }

    public void printReturnOfRate(double returnOfRate) {
        System.out.println(START_RETURN_OF_RATE_MESSAGE + returnOfRate + END_RETURN_OF_RATE_MESSAGE);
    }
}
