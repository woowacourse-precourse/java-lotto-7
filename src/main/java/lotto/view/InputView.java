package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readPriceInput(){
        String price = Console.readLine();
        return Integer.parseInt(price);
    }

}
