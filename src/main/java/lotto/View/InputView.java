package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_PurchaseAmount="구입금액을 입력해 주세요.";
    private static final String ERROR_PurchaseAmount="[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.";

    public static int input_purchaseAmount(){
        boolean validInput=false;
        int parchase_amount = 0;
        while(!validInput){
            System.out.println(ASK_PurchaseAmount);
            String input_purchase_amount= readLine();
            if(check_invalidAmount(input_purchase_amount)){
                parchase_amount=Integer.parseInt(input_purchase_amount);
                validInput=true;
            }else{
                throw new IllegalArgumentException(ERROR_PurchaseAmount);
            }
        }
        return parchase_amount;
    }

    private static boolean check_invalidAmount(String purchase_amount){
        int amount=Integer.parseInt(purchase_amount);
        if(amount%1000==0&&amount>0) return true;
        return false;
    }
}
