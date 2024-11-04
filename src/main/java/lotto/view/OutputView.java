package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Match;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(String.join(", ", lotto.getLottoNumber()
                    .stream()
                    .map(number -> String.valueOf(number))
                    .toList()));
            sb.append("]");
            print(sb.toString());
        }
        print("");
    }

}
