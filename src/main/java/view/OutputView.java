package view;

import java.util.List;
import model.Lotto;

public class OutputView {

    public static void printInputMessage(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printLottoPurchasing(Integer count, List<Lotto> lottos) {
        String outputMessage = OutputMessage.INPUT_LOTTO_COUNT_MESSAGE.getMessage();
        System.out.println(String.format(outputMessage, count));
        printLottos(lottos);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
