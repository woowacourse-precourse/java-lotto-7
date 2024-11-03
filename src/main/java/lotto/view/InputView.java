package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.OutputView.printInputPrice;

public class InputView {
    public static String inputPrice() {
        printInputPrice();
        String price = readLine();
        return price;
    }
}
