package lotto.view;

import static lotto.constants.Output_Messages.MATCH_MESSAGE;
import static lotto.view.input.printWhiteSpace;

import java.util.List;
import lotto.constants.Request_Messages;
import lotto.controller.LottoController;
import lotto.model.Lotto;

public class output {
    public static void printOutputTotalCount(int count){
        System.out.println(count + Request_Messages.OUTPUT_TOTAL_COUNT);
    }

    public static void printSummaryMessage(){
        System.out.println(Request_Messages.SUMMARY);
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
        for (int i = 0; i < winCounts.size() - 1; i++) {
            System.out.println(MATCH_MESSAGE[i] + winCounts.get(4-i) + "개");
        }
    }

    public static void printLottoReturn(float lottoReturn){
        System.out.println("총 수익률은 " + String.format("%.1f", lottoReturn) + "%입니다.");
    }
}
