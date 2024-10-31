package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public void inputPurchaseAmount() {
        String input = readLine();
        int amount = Integer.parseInt(input);
    }

}
