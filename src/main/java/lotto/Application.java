package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        UserLottos userLottos = createUserLottos();
    }

    private static UserLottos createUserLottos() {
        while (true) {
            try {
                int purchaseAmount = CommonValidation.convertStringToInt(inputPurchaseAmount());
                return new UserLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputPurchaseAmount() {
        System.out.println(IOMessage.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }
}
