package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputHandler {
    public final InputValidator inputValidator;

    public InputHandler(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int purchaseAmount = parseToInt(input);
                inputValidator.checkDividedBy1000(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseToInt(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자 형식이 아닙니다.");
        }
    }
}
