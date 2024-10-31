package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;


public class PurchaseAmountInputView {
    public static int inputPurchaseAmount() {
        while(true) {
            try {
                return getValidatedPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }
    private static int getValidatedPurchaseAmount(){
        System.out.println("구매할 금액을 입력해주세요.");
        String purchaseAmountInput=Console.readLine();
        int purchaseAmount= Validator.parseAmount(purchaseAmountInput);
        Validator.validateAmount(purchaseAmount);
        return purchaseAmount;
    }
}
