package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        UserLottos userLottos = createUserLottos();
        showUserLottos(userLottos);
        inputWinningNumbers();
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

    private static void showUserLottos(UserLottos userLottos) {
        System.out.println();
        System.out.println(userLottos.getQuantity() + IOMessage.PURCHASE_QUANTITY.getMessage());
        System.out.println(getUserLottos(userLottos));
    }

    private static String getUserLottos(UserLottos userLottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : userLottos.getLottos()) {
            sb.append(lotto.getNumbers().toString()).append("\n");
        }
        return sb.toString();
    }

    private static String inputWinningNumbers() {
        System.out.println(IOMessage.WINNING_NUMBERS.getMessage());
        return readLine();
    }
}
