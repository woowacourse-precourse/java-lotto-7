package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.message.SystemMessage;
import lotto.model.Lotto;

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
        System.out.println(SystemMessage.MESSAGE_INPUT_WINNING_NUMBERS.getMessage());
    }

    /**
     * 사용자에게 보너스 번호 입력 문구 출력
     */
    public static void printBonusNumberMessage() {
        System.out.println(SystemMessage.MESSAGE_INPUT_BONUS_NUMBER.getMessage());
    }
}
