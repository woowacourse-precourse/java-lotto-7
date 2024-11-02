package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
    private final static String NEW_LINE = System.lineSeparator();
    private final static String LOTTO_COUNT_STRING = "개를 구매했습니다.";
    private final static String WINNING_STATISTIC_STRING = "당첨 통계\n---";
    private final static String FIFTH_RANK = "3개 일치 (5,000원) - ";
    private final static String FOURTH_RANK = "4개 일치 (50,000원) - ";
    private final static String THIRD_RANK = "5개 일치 (1,500,000원) - ";
    private final static String SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String FIRST_RANK = "6개 일치 (2,000,000,000원) - ";
    private final static String COUNT_STRING = "개";
    private final static String RETURN_RATE_BEGIN_STRING = "총 수익률은 ";
    private final static String RETURN_RATE_END_STRING = "%입니다.";

    public void printLottoCount(int lottoCount) {
        System.out.println(NEW_LINE+ lottoCount + LOTTO_COUNT_STRING);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printResult(Map<Rank, Integer> rankResult, double rateOfReturn) {
        System.out.println(NEW_LINE + WINNING_STATISTIC_STRING);
        System.out.println(FIFTH_RANK + rankResult.get(Rank.FIFTH) + COUNT_STRING);
        System.out.println(FOURTH_RANK + rankResult.get(Rank.FOURTH) + COUNT_STRING);
        System.out.println(THIRD_RANK + rankResult.get(Rank.THIRD) + COUNT_STRING);
        System.out.println(SECOND_RANK + rankResult.get(Rank.SECOND) + COUNT_STRING);
        System.out.println(FIRST_RANK + rankResult.get(Rank.FIRST) + COUNT_STRING);
        System.out.println(RETURN_RATE_BEGIN_STRING + String.format("%.1f", rateOfReturn) + RETURN_RATE_END_STRING);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
