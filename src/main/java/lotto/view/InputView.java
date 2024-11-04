package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public String promptPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        return inputAmount;
    }

}
