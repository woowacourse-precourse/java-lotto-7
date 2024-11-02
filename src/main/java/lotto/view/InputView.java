package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
