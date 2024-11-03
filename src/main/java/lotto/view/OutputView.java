package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.enums.Rank;

public class OutputView {
    private static final String INPUT_LOTTO_PURCHASE_COST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "%d개를 구입했습니다.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_INFORMATION_MESSAGE = "%s - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public void printLottoPurchaseCostMessage() {
        System.out.println(INPUT_LOTTO_PURCHASE_COST_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASE_LOTTO_MESSAGE, lottos.size()));
        lottos.forEach(System.out::println);
    }

    public void printInputLottoWinningNumbersMessage() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS);
    }

    public void printInputLottoBonusNumberMessage() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER);
    }

    public void printResult(MatchLottoResult matchLottoResult, RateOfReturn rateOfReturn) {
        System.out.println(RESULT_MESSAGE);
        for (Map.Entry<Rank, Integer> entry : matchLottoResult.result().entrySet()) {
            System.out.println(
                    String.format(RESULT_INFORMATION_MESSAGE, entry.getKey().getMessage(), entry.getValue()));
        }
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn.rate()));
    }

    public void printErrorMessage(Exception e) {
        System.out.println(String.format(ERROR_MESSAGE, e.getMessage()));
    }
}
