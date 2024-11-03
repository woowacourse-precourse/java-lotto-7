package view;

import java.util.HashMap;
import java.util.List;
import model.Lotto;
import model.LottoResult;

public class OutputView {

    public static void printInputMessage(OutputMessages message) {
        printBlankLine();
        System.out.println(message.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printPurchasingLottos(Integer lottoCount, List<Lotto> lottos) {
        printBlankLine();
        String outputMessage = OutputMessages.OUTPUT_LOTTO_COUNT_MESSAGE.getMessage();
        System.out.println(String.format(outputMessage, lottoCount));
        printEachLottos(lottos);
    }

    public static void printEachLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoRankCount(HashMap<LottoResult, Integer> lottoResult, Double earnRate) {
        printInputMessage(OutputMessages.OUTPUT_LOTTO_STATISTICS_MESSAGE);
        printRankResult(lottoResult);
        printEarnRate(earnRate);
    }

    public static void printRankResult(HashMap<LottoResult, Integer> result) {
        List<LottoResult> printSequences = List.of(LottoResult.FIRST,
                LottoResult.SECOND,
                LottoResult.THIRD,
                LottoResult.FOURTH,
                LottoResult.FIFTH);
        for (LottoResult element : printSequences) {
            printResultElement(result, element);
        }
    }

    public static void printResultElement(HashMap<LottoResult, Integer> result, LottoResult element) {
        String outputMessage = OutputMessages.OUTPUT_RANK_STATISTICS_MESSAGE.getMessage();
        if (result.get(element) == null) {
            System.out.println(String.format(outputMessage, element.getMessage(), 0));
            return;
        }
        System.out.println(String.format(outputMessage, element.getMessage(), result.get(element)));
    }

    public static void printEarnRate(Double earnRate) {
        String outputMessage = OutputMessages.OUTPUT_EARN_RATE_MESSAGE.getMessage();
        System.out.println(String.format(outputMessage, earnRate));
    }
}
