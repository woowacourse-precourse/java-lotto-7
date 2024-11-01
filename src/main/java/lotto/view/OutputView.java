package lotto.view;

import lotto.Message.ViewMessage;
import lotto.model.Lotto;
import java.util.List;

public class OutputView {

    public static void printAmount(int amount) {
        System.out.println(amount + "" + ViewMessage.OUTPUT_GET_AMOUNT);
    }

    public static void printBonusNum(int bonus){
        System.out.println(bonus);
    }

    // 나눠야 댐
    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
