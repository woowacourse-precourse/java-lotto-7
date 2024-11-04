package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {

        int purchaseAmount = getValidPurchaseAmount();
    }

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();

                validateInput(input);
                int purchaseAmount = validatePurchaseAmountInput(input);
                validatePurchaseAmount(purchaseAmount);

                return Integer.parseInt(input); // 입력이 유효하면 변환 후 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 루프 반복하여 재입력 요청
            }
        }
    }

    public static void validateInput(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다. 다시 입력해 주세요.");
        }
    }

    public static int validatePurchaseAmountInput(String input) {

        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        return Integer.parseInt(input);
    }

    public static void validatePurchaseAmount(int purchaseAmount) {

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
