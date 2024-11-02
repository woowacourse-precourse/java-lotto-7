package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.MyLottos;

import static lotto.Utils.PrintConstants.OUTPUT_NUMBER_OF_TICKETS;


public class OutputMyLottosView {
    public void printMylottos(MyLottos myLottos) {
        System.out.println(myLottos.size() + OUTPUT_NUMBER_OF_TICKETS);
        for (Lotto lotto : myLottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
