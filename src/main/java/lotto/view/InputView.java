package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {

    public long inputPurchaseAmount(){
        return Long.parseLong(Console.readLine());
    }

    public String inputWinningNumber(){
        return Console.readLine();
    }

}
