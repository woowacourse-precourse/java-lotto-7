package view;

import java.util.function.Supplier;

public class InputView {

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public String chargeMoneyInput() {
        return repeatLoop(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String money = reader.get();
            System.out.println();
            return money;
        });
    }

    public String winningNumberInput() {
        return repeatLoop(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumber = reader.get();
            return winningNumber;
        });
    }

    public String bonusNumberInput() {
        return repeatLoop(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = reader.get();
            return bonusNumber;
        });
    }

    private <T> T repeatLoop(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
