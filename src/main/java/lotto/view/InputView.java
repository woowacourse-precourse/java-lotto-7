package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputConstant;

public class InputView {
    public String inputPurchaseAmount(){
        System.out.println(InputConstant.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();

    }
    public String inputPrimaryNumber(){
        System.out.println(InputConstant.INPUT_PRIMARY_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(InputConstant.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
