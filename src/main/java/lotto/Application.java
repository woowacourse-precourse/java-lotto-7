package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseLottos();
    }

    private static int purchaseLottos() {
        try {
            String purchaseAmountInput = inputPurchaseAmount();
            int purchaseAmount = countLottoAmount(purchaseAmountInput);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos();
        }
    }

    private static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateInputInteger(purchaseAmount);
        return purchaseAmount;
    }

    public static void validateInputInteger(String inputInteger) {
        if (inputInteger == null
                || inputInteger.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
        if (!inputInteger.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (inputInteger.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }

    public static int countLottoAmount(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }
        return purchaseAmount / 1000;
    }
}
