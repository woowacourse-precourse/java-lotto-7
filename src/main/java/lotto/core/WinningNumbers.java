package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidationUtils;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    public static final String DELIMITER = ",";

    private String inputNumbers;
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {
        this.init();
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void init() {
        while (true) {
            try {
                this.inputNumbers = this.inputNumberString("당첨 번호를 입력해 주세요.");
                this.setWinningNumbers();
                this.setBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                this.printErrorMessage(e);
            }
        }
    }

    private void setWinningNumbers() {
        List<Integer> numbers = Arrays.stream(this.inputNumbers.split(DELIMITER))
            .map(String::trim)
            .map(InputValidationUtils::parseInteger)
            .toList();
        this.winningNumbers = new Lotto(numbers);
    }

    private void setBonusNumber() {
        while (true) {
            try {
                int bonusNumber = InputValidationUtils.parseInteger(this.inputNumberString("보너스 번호를 입력해 주세요."));
                InputValidationUtils.validateBonusNumber(
                    bonusNumber, this.winningNumbers.getNumbers()
                );
                this.bonusNumber = bonusNumber;
                break;
            } catch (IllegalArgumentException e) {
                this.printErrorMessage(e);
            }
        }
    }

    private String inputNumberString(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private void printErrorMessage(Exception e) {
        System.out.println("\n" + LottoRunner.ERROR_PREFIX + e.getMessage());
    }
}
