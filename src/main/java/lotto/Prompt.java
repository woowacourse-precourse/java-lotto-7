package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Prompt {
    public static BonusNumber promptBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String bonusNumberInput = readLine();
            try {
                return new BonusNumber (bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto promptWinningLotto() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningLottoInput = readLine();
            try {
                List<Integer> winningLottoNumbers = Arrays.stream(winningLottoInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                return new Lotto(winningLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String promptPurchaseAmount() {
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
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
