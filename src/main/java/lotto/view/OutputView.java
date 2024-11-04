package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.SystemMessage;
import lotto.constant.Constants;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

    /**
     * 사용자에게 구매 금액 입력 문구 출력
     */
    public static void printPurchaseAmountMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_PURCHASE_AMOUNT.getMessage());
    }

    /**
     * 사용자가 구매한 로또 갯수 출력
     */
    public static void printLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + SystemMessage.MESSAGE_OUTPUT_PURCHASE_LOTTO_QUANTITY.getMessage());
    }

    /**
     * 사용자가 구매한 List<Lotto> 출력
     */
    public static void printLottoList(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLotto();
        String numbersString = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("[" + numbersString + "]");
    }

    /**
     * 사용자에게 당첨 로또 번호 입력 문구 출력
     */
    public static void printWinningLottoNumbersMessage() {
        System.out.println();
        System.out.println(SystemMessage.MESSAGE_INPUT_WINNING_NUMBERS.getMessage());
    }

    /**
     * 사용자에게 보너스 번호 입력 문구 출력
     */
    public static void printBonusNumberMessage() {
        System.out.println();
        System.out.println(SystemMessage.MESSAGE_INPUT_BONUS_NUMBER.getMessage());
    }

    /**
     * 사용자에게 결과 출력 문구 출력
     */
    public static void printResultMessage() {
        System.out.println();
        System.out.println(SystemMessage.MESSAGE_OUTPUT_RESULT.getMessage());
        System.out.println(Constants.RESULT_DIVISION);
    }

    /**
     * 사용자에게 결과 출력
     */
    public static void printResult(EnumMap<LottoRank, Integer> rankCounts) {
        rankCounts.forEach((rank, count) -> {
            if (rank != LottoRank.NONE) {
                String matchInfo = rank.getMatchInfo();
                System.out.printf("%s (%s원) - %d개\n", matchInfo, String.format("%,d", rank.getPrize()), count);
            }
        });
    }

    /**
     * 사용자에게 수익률 출력
     */
    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    /**
     * 에러 메세지 출력
     */
    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.println(message);
    }
}
