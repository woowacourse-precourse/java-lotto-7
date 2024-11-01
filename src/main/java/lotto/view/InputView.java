package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();

                // 유효성 검증 (예외 발생 가능)
                validatePurchaseAmount(purchaseAmount);

                return purchaseAmount;

            } catch (IllegalArgumentException e) {
                // 에러 메시지 출력 후 다시 입력 받기
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public String[] inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine().replace("\\s", "");
        return input.split(",");
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Console.readLine();
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        checkEmptyInput(purchaseAmount);
        checkNumericInput(purchaseAmount);
        checkPositiveAmount(purchaseAmount);
    }

    // 1. 입력값이 비어있는지 검증
    private void checkEmptyInput(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("구매 금액을 입력해주세요.");
        }
    }

    // 2. 숫자로만 이루어져 있는지 검증
    private void checkNumericInput(String purchaseAmount) {
        if (!purchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException(purchaseAmount + "은(는) 잘못된 입력입니다.");
        }
    }

    // 3. 음수 또는 0 금액인지 검증
    private void checkPositiveAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (amount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0원 이상이어야 합니다.");
        }
    }
}
