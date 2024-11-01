package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.InputParser;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printMoneyRequest() {
        System.out.println(Outputs.MONEY_REQUEST.getMessage());
    }

    public void printLottoBought(List<Lotto> lottos) {
        System.out.println();
        System.out.println(InputParser.getComma(lottos.size()) + Outputs.LOTTO_BOUGHT.getMessage());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
