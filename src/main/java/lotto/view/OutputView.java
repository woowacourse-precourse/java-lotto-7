package lotto.view;

import lotto.model.Lotto;
import lotto.constant.GameMessage;
import lotto.constant.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(GameMessage.REQUEST_PURCHASE_AMOUNT);
    }

    public static void printLottoTickets(int numberOfTickets, List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(GameMessage.PURCHASED_LOTTO_COUNT, numberOfTickets));
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void requestWinningNumbers() {
        System.out.println();
        System.out.println(GameMessage.REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println();
        System.out.println(GameMessage.REQUEST_BONUS_NUMBER);
    }

    public static void printResultTitle() {
        System.out.println();
        System.out.println(GameMessage.WINNING_STATISTICS);
        System.out.println(GameMessage.STATISTICS_DIVIDER);
    }

    public static void printWinningResults(Map<Rank, Integer> prizeResults) {
        for (Rank prize : Rank.values()) {
            if (prize == Rank.NONE) {
                continue;
            }
            String resultMessage = GameMessage.MATCH_RESULT_FORMAT;
            if (prize.isBonusMatched()) {
                resultMessage = GameMessage.MATCH_BONUS_RESULT_FORMAT;
            }
            System.out.println(String.format(
                    resultMessage,
                    prize.getCorrectNumberCount(),
                    prize.getPrize(),
                    prizeResults.getOrDefault(prize,0)));
        }
    }

    public static void printBenefitRate(String benefitRate){
        System.out.println(String.format(GameMessage.TOTAL_RETURN_RATE, benefitRate));

    }
}
