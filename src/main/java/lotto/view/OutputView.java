package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.OutputMessage;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoAmountInput() {
        System.out.println(OutputMessage.REQUEST_INPUT_AMOUNT);
    }

    public static void printLottoNumberOutput(int lottoAmount, List<Lotto> lottos) {
        System.out.println(lottoAmount + OutputMessage.PRINT_LOTTO_NUMBER.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberInput(){
        System.out.println(OutputMessage.REQUEST_INPUT_WINNING_NUMBER);
    }

    public static void printBonusNumberInput(){
        System.out.println(OutputMessage.REQUEST_INPUT_BONUS_NUMBER);
    }
}
