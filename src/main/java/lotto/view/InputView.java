package lotto.view;

import java.util.Scanner;

import static lotto.util.NumberUtil.parsePositiveNumber;


public class InputView {
    Scanner sc = new Scanner(System.in);

    public String promptPurchaseAmount(){
        String inputAmount = sc.next();
        return inputAmount;
    }

}
