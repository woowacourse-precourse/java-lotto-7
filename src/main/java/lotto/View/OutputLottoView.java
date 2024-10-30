package lotto.View;

import lotto.Enum.PrintConstants;
import lotto.Model.Lotto;
import lotto.Model.MyLottos;

public class OutputLottoView {
    public void printMylottos(MyLottos myLottos) {
        System.out.println(myLottos.size() + PrintConstants.OUTPUT_NUMBER_OF_TICKETS.getMessage());
        for (Lotto lotto : myLottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
