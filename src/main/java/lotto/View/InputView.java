package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_PurchaseAmount="구입금액을 입력해 주세요.";
    private static final String ERROR_PurchaseAmount="[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.";
//    private static final String ASK_WinningNumber="당첨 번호를 입력해 주세요.";

    public static int input_purchaseAmount() {
        while (true) {
            System.out.println(ASK_PurchaseAmount);
            String input_purchase_amount = readLine();
            if (isValidAmount(input_purchase_amount)) {
                return parsePurchaseAmount(input_purchase_amount);
            }
            ErrorInvalidAmount();
        }
    }
    private static boolean isValidAmount(String input_purchase_amount) {
        return check_invalidAmount(input_purchase_amount);
    }
    private static int parsePurchaseAmount(String input_purchase_amount) {
        return Integer.parseInt(input_purchase_amount);
    }
    private static void ErrorInvalidAmount(){
        throw new IllegalArgumentException(ERROR_PurchaseAmount);
    }
    private static boolean check_invalidAmount(String purchase_amount){
        int amount=Integer.parseInt(purchase_amount);
        if(amount%1000==0&&amount>0) return true;
        return false;
    }
}
