package lotto.view.output;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.exception.ErrorHandler;
import lotto.model.domain.Lotto;
import lotto.model.service.LottoPrize;

public class OutputView implements ErrorHandler {
    private final static String ERROR = "[ERROR] ";
    private final static String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private final static String LOTTO_COUNT_NOTICE = "개를 구매했습니다.";
    private final static String WINNING_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
    private final static String WINNING_REPORT_NOTICE = "당첨 통계\n---";
    private final static String PROFIT_RATIO_NOTICE = "총 수익률은 %s%%입니다.";
    private final static String WINNING_TEXT = "%d개 일치 (%s) - %d개";
    private final static String WINNING_WITH_BONUS_TEXT = "%d개 일치, 보너스 볼 일치 (%s) - %d개";

    @Override
    public void printError(String message) {
        System.out.println(ERROR + message);
    }

    public void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
    }

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_COUNT_NOTICE);

        String result = String.join("\n", lottos.stream()
                .map(Lotto::toString)
                .toList());

        System.out.println(result);
    }

    public void printWinningNumbersRequest() {
        System.out.println(WINNING_NUMBERS_REQUEST);
    }

    public void printBonusNumberRequest() {
        System.out.println(BONUS_NUMBER_REQUEST);
    }

    public void printWinningReport(List<LottoPrize> winners) {
        System.out.println(WINNING_REPORT_NOTICE);
        Map<LottoPrize, Integer> prizesAndNumber = convertToMap(winners);
        List<String> winningResult = makeWinningReportView(prizesAndNumber);
        String result = String.join("\n", winningResult);
        System.out.println(result);
    }

    public void printProfitRatio(Double profitRatio) {
        String commaProfitRatio = String.format("%,.1f", profitRatio);
        System.out.println(String.format(PROFIT_RATIO_NOTICE, commaProfitRatio));
    }

    private Map<LottoPrize, Integer> convertToMap(List<LottoPrize> winners) {
        Map<LottoPrize, Integer> prizesAndNumber = new HashMap<>();
        for (LottoPrize prize : winners) {
            int numberOfPrize = prizesAndNumber.getOrDefault(prize, 0);
            prizesAndNumber.put(prize, numberOfPrize + 1);
        }
        return prizesAndNumber;
    }

    private List<String> makeWinningReportView(Map<LottoPrize, Integer> winnings) {
        List<LottoPrize> lottoPrizes = Arrays.stream(LottoPrize.values()).toList();

        return lottoPrizes.stream().map(prize -> {
            if (prize.isBonusCorrect()) {
                return String.format(WINNING_WITH_BONUS_TEXT, prize.getCorrectCount(),
                        prize.getCommaPrize(), winnings.getOrDefault(prize, 0));
            }
            return String.format(WINNING_TEXT, prize.getCorrectCount(),
                    prize.getCommaPrize(), winnings.getOrDefault(prize, 0));

        }).toList();
    }
}
