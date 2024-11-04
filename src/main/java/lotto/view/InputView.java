package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String INSUFFICIENT_AMOUNT_ERROR_MESSAGE = "1000원 미만으론 구매할 수 없음";

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        int amount;
        try {
            amount = Integer.parseInt(Console.readLine());
            validCanPurchaseLotto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + INSUFFICIENT_AMOUNT_ERROR_MESSAGE);
            return inputPurchaseAmountGuide();
        }
        return calculateNumberOfTotalLotto(amount);
    }

    public void validCanPurchaseLotto(int totalAmount) {
        if (totalAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INSUFFICIENT_AMOUNT_ERROR_MESSAGE);
        }
    }

    public int calculateNumberOfTotalLotto(int amount) {
        return amount / LOTTO_PRICE;
    }

}
