package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {

    private static final int LOTTO_PRICE = 1000;

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        checkIfPurchaseAmountValid(input);
        return Integer.parseInt(input);
    }

    public static void checkIfPurchaseAmountValid(String input) {
        isInputEmpty(input);
        isNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        isDividedByLottoPrice(purchaseAmount);
    }

    public static void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력하세요.");
        }
    }

    public static void isDividedByLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 로또 가격 단위로 이루어져야 합니다.");
        }
    }

    public static void isNumeric(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
    }
}
