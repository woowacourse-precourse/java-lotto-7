package lotto.view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public String promptPurchaseAmount(){
        String purchaseAmount = sc.next();
        return purchaseAmount;
    }

}
