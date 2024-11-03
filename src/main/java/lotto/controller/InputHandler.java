package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.model.LottoGenerator;
import lotto.view.OutputView;

public class InputHandler {
    private final OutputView outputView;

    public InputHandler(final OutputView outputView, LottoGenerator lottoGenerator) {
        this.outputView = outputView;
    }

    public int readPurchaseAmount() {
        outputView.printRequirePurchasePrice();
        String input = readLine();
        final int amount = parseToInteger(input);
        validatePositive(amount);
        return amount;
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validatePositive(int input) {
        final int zero = 0;
        if (input < zero) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력 가능합니다.");
        }
    }
}
