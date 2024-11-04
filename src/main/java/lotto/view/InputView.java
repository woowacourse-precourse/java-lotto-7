package lotto.view;

import java.util.Scanner;

import static lotto.util.NumberUtil.parsePositiveNumber;


public class InputView {
    Scanner sc = new Scanner(System.in);

    public String promptPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = sc.next();
        return inputAmount;
    }

}
