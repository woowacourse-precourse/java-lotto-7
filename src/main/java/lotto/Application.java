package lotto;

import java.util.Collections;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String purchaseAmountInput = promptPurchaseAmount();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(purchaseAmountInput);
        List<List<Integer>> purchasedLottos = lottoPurchaser.purchaseLotto();
        printPurchasedLottos(purchasedLottos);
    }

    private static void printPurchasedLottos(List<List<Integer>> purchasedLottos) {
        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        for (List<Integer> purchasedlotto : purchasedLottos){
            Collections.sort(purchasedlotto);
            System.out.println(purchasedlotto);
        }
    }

    private static String promptPurchaseAmount() {
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = readLine();
            try {
                validatePurchaseAmount(purchaseAmountInput);
                return purchaseAmountInput;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmountInput) {
        validateIntegerInput(purchaseAmountInput);
        validateThousandUnit(purchaseAmountInput);
    }

    private static void validateIntegerInput(String purchaseAmountInput) {
        boolean isInteger = purchaseAmountInput.chars().allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private static void validateThousandUnit(String purchaseAmountInput) {
        int amount = Integer.parseInt(purchaseAmountInput);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
