package lotto.view;

import static lotto.view.input.printWhiteSpace;

import java.util.List;
import lotto.constants.Request_Messages;
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

    public static void printBoughtLottos(int count, List<Lotto> Lottos){
        printOutputTotalCount(count);
        printLottos(Lottos);
        printWhiteSpace();
    }
}
