package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputPurchaseAmount = Console.readLine().replace(" ", "");
                validatePurchaseAmount(inputPurchaseAmount);
                return Integer.parseInt(inputPurchaseAmount);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(String inputPurchaseAmount) {
    }

    public List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine().replace(" ", "");
                String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
                validateWinningNumbers(splitInputWinningNumbers);
                return Arrays.stream(splitInputWinningNumbers).map(winningNumber ->
                        Integer.parseInt(winningNumber)
                ).toList();
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbers(String[] splitInputWinningNumbers) {
    }

    public int getValidBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine().replace(" ", "");
                validateBonusNumber(inputBonusNumber);
                return Integer.parseInt(inputBonusNumber);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(String inputBonusNumber) {
    }
}
