package lotto.view;

import static lotto.view.input.printWhiteSpace;

import java.util.List;
import lotto.Constants.OutputMessages;
import lotto.Constants.RequestMessages;
import lotto.controller.LottoController;
import lotto.model.Lotto;

public class output {
    public static void printOutputTotalCount(int count){
        System.out.println(count + RequestMessages.OUTPUT_TOTAL_COUNT.getMessage());
    }

    public static void printSummaryMessage(){
        System.out.println(RequestMessages.SUMMARY.getMessage());
    }

    public static void printLottos(List<Lotto> Lottos){
        for (Lotto lotto : Lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printBoughtLottos(LottoController lottoController){
        printWhiteSpace();
        printOutputTotalCount(lottoController.getTotalCount());
        printLottos(lottoController.getLottos());
    }

    public static void printWinCounts(List<Integer> winCounts){
        printSummaryMessage();
        int i = 0;
        for (OutputMessages outputMessage : OutputMessages.values()) {
            System.out.println(outputMessage.getMessage() + winCounts.get(4 - i) + "개");
            i++;
        }
    }

    public static void printLottoReturn(float lottoReturn){
        System.out.println("총 수익률은 " + String.format("%.1f", lottoReturn) + "%입니다.");
    }

    public static void printSummary(List<Integer> winCounts, float lottoReturn){
        printWinCounts(winCounts);
        printLottoReturn(lottoReturn);
    }
}
