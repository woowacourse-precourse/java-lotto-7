package view;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import model.Lotto;
import model.LottoResult;

public class OutputView {

    public static void printInputMessage(OutputMessage message) {
        printBlankLine();
        System.out.println(message.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printLottoPurchasing(Integer count, List<Lotto> lottos) {
        printBlankLine();
        String outputMessage = OutputMessage.OUTPUT_LOTTO_COUNT_MESSAGE.getMessage();
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

    public static void printLottoRankCount(HashMap<LottoResult, Integer> result, Double earnRate) {
        printInputMessage(OutputMessage.OUTPUT_WINNING_RESULT_MESSAGE);
        printRankResult(result);
        printEarnRate(earnRate);
    }

    public static void printRankResult(HashMap<LottoResult, Integer> result) {
        List<LottoResult> printSequences = asList(LottoResult.FIRST, LottoResult.SECOND,
                LottoResult.THIRD, LottoResult.FOURTH, LottoResult.FIFTH);
        for (LottoResult element : printSequences) {
            ;
            printElement(result, element);
        }

    }

    public static void printElement(HashMap<LottoResult, Integer> result, LottoResult element) {
        String outputMessage = OutputMessage.OUTPUT_ELEMENT_RESULT_MESSAGE.getMessage();
        if (result.get(element) == null) {
            System.out.println(String.format(outputMessage, element.getMessage(), 0));
            return;
        }
        System.out.println(String.format(outputMessage, element.getMessage(), result.get(element)));
    }

    public static void printEarnRate(Double earnRate) {
        String outputMessage = OutputMessage.OUTPUT_RETURN_RATE_MESSAGE.getMessage();
        System.out.println(String.format(outputMessage, earnRate));
    }
}
