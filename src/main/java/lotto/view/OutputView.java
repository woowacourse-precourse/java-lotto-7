package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.enums.Rank;

public class OutputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "%d개를 구입했습니다.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_INFORMATION_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_RESULT_MESSAGE = ", 보너스 볼 일치";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %d%%입니다.";

    public void printLottoPurchaseAmountMessage() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(String.format(PURCHASE_LOTTO_MESSAGE, lottos.getLottos().size()));
        lottos.getLottos().forEach(System.out::println);
    }

    public void printInputLottoWinningNumbersMessage() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS);
    }

    public void printInputLottoBonusNumberMessage() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
    }

    public void printResult(MatchLottoResult matchLottoResult, RateOfReturn rateOfReturn) {
        System.out.println(RESULT_MESSAGE);
        for (Map.Entry<Integer, Integer> result : matchLottoResult.result().entrySet()) {
            Rank rank = Rank.getRankByValue(result.getKey());

            if (rank.getValue() == 5) {
                System.out.println(String.format(RESULT_INFORMATION_MESSAGE, rank.getMatchCount(), BONUS_RESULT_MESSAGE,
                        rank.getReword(), result.getValue()));
                continue;
            }
            System.out.println(String.format(RESULT_INFORMATION_MESSAGE, rank.getMatchCount(), "", rank.getReword(),
                    result.getValue()));
        }
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn.rate()));
    }
}
