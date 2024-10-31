package view;

import java.util.List;
import domain.Lotto;

public class OutputView {

    public static void printLottoNumber(List<Lotto> lottos) {
        System.out.println(ViewMessage.PURCHASE_CONFIRMATION_MESSAGE.format(lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningHistory() {
        System.out.println(ViewMessage.WINNING_STATISTIC_MESSAGE);
    }

}
