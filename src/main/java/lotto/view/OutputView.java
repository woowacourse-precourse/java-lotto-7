package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.constant.SystemMessage;

public class OutputView {
    public void printGeneratedLottos(int number, List<Lotto> lottolist) {
        System.out.printf(SystemMessage.Display_NumberOfPerchasedLottos.getMessage(), number);
        System.out.println();
        for (Lotto lotto : lottolist) {
            System.out.println(lotto.printLottos());
        }
        System.out.println();
    }

}
