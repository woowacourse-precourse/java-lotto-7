package lotto;

import java.util.function.Supplier;

public class InputHandler {
    private final Input input;

    public InputHandler(Input input) {
        this.input = input;
    }

    public Integer handleAmount() {
        return handle(input::getAmountWithGuide);
    }

    public Lotto handleWinNumbers() {
        return handle(input::getWinNumbersWithGuide);
    }

    public WinningNumbers handleBonusNumber(Lotto lotto) {
        return handle(() -> input.getBonusNumberWithGuide(lotto));
    }

    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
