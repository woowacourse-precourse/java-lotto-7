package view;

import view.validation.InputValidator;

import java.util.List;
import java.util.function.Supplier;

public class InputView {

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public int chargeMoneyInput() {
        return repeatLoop(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String money = reader.get();
            System.out.println();
            int charge = InputValidator.validateMoney(money);
            return charge;
        });
    }

    public List<Integer> winningNumberInput() {
        return repeatLoop(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumber = reader.get();
            List<Integer> winningNumbers = InputValidator.validateWinningNumber(winningNumber);
            return winningNumbers;
        });
    }

    public int bonusNumberInput() {
        return repeatLoop(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = reader.get();
            int bonusNum = InputValidator.validateBonusNumber(bonusNumber);
            return bonusNum;
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
