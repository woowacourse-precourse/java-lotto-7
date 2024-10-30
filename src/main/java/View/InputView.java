package View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import Constant.Constant;
import Util.Validator;

public class InputView {
    public Integer getPurchaseAmount() {
        System.out.println(Constant.MessageConstant.INPUT_PURCHASE_PROMPT);
        String PurchaseAmount = Console.readLine();
        Validator.validPurchaseAmount(PurchaseAmount);
        return Integer.parseInt(PurchaseAmount);
    }


}
