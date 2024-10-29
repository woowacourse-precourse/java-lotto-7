package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        try{
            String inputPurchaseAmount = readLine();
            int purchaseAmount = PurchaseAmountValidator.isInvalidPurchaseAmount(inputPurchaseAmount);
            return purchaseAmount;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR]" + e.getMessage());
            return inputPurchaseAmount();
        }
    }
}