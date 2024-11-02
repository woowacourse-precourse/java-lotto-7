package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.PurchaseAmount;

public class InputHandler {

    public PurchaseAmount inputPurChaseAmount(){

        System.out.println("구입금액을 입력해 주세요.");

        return new PurchaseAmount(Console.readLine());
    }

}
