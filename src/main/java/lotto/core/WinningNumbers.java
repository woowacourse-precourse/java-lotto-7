package lotto.core;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    public static final String DELIMITER = ",";

    private String numberString;
    private Lotto winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public WinningNumbers() {
        this.init();
    }

    public void init() {
        while (true) {
            try {
                this.numberString = this.inputNumberString("당첨 번호를 입력해 주세요.");
                this.setWinningNumbers();
                this.setBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                this.printErrorMessage(e);
            }
        }
    }

    private void setWinningNumbers() {
        List<Integer> numbers = Arrays.stream(this.numberString.split(DELIMITER))
            .map(String::trim)
            .map(InputValidationUtils::parseInteger)
            .toList();
        this.winningNumbers = new Lotto(numbers);
    }

    private void setBonusNumber() {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(this.inputNumberString("보너스 번호를 입력해 주세요."));
                this.validateBonusNumber(bonusNumber);
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

    private void validateBonusNumber(int bonusNumber) {
        this.validateRange(bonusNumber);
        this.validateUniqueNumbers(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        boolean isOutOfRange = this.checkRange(bonusNumber);
        this.throwOutOfRange(isOutOfRange);
    }

    private boolean checkRange(int num) {
        return num > Lotto.MAX_LOTTERY_NUMBER || num < Lotto.MIN_LOTTERY_NUMBER;
    }

    private void throwOutOfRange(boolean isOutOfRange) {
        if (isOutOfRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateUniqueNumbers(int bonusNumber) {
        if (this.winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void printErrorMessage(Exception e) {
        System.out.println("\n" + LottoRunner.ERROR_PREFIX + e.getMessage());
    }
}
