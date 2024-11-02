package lotto.view;

import lotto.Lotto;
import lotto.constant.MessageConstants;
import lotto.constant.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(MessageConstants.REQUEST_PURCHASE_AMOUNT);
    }

    public static void printLottoTickets(int purchaseCount, List<Lotto> lottos) {
        System.out.println(String.format(MessageConstants.PURCHASED_LOTTO_COUNT, purchaseCount));
        lottos.forEach(System.out::println);
    }

    public static void requestWinningNumbers() {
        System.out.println(MessageConstants.REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(MessageConstants.REQUEST_BONUS_NUMBER);
    }

    public static void printResult(String benefitRate, Map<Prize, Integer> prizeResults) {
        System.out.println(MessageConstants.WINNING_STATISTICS);
        System.out.println(MessageConstants.STATISTICS_DIVIDER);
        printWinningResults(prizeResults);
        System.out.println(String.format(MessageConstants.TOTAL_RETURN_RATE, benefitRate));
    }

    public static void printWinningResults(Map<Prize, Integer> prizeResults) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                break;
            }
            String resultMessage = MessageConstants.MATCH_RESULT_FORMAT;
            if (prize.isBonusMatch()) {
                resultMessage = MessageConstants.MATCH_BONUS_RESULT_FORMAT;
            }
            System.out.println(String.format(
                    resultMessage,
                    prize.getMatchCount(),
                    prize.getPrize(),
                    prizeResults.get(prize)));
        }
    }
}
