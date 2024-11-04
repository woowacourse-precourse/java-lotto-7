package lotto.inputview;
import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseAmountValidator;


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
        int purchaseAmount= PurchaseAmountValidator.parseAmount(purchaseAmountInput);
        PurchaseAmountValidator.validateAmount(purchaseAmount);
        return purchaseAmount/1000;
    }
}
