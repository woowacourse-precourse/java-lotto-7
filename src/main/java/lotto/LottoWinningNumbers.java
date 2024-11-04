package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void inputWinningNumbers() {
        winningNumbers.clear();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        try {
            validateWinningNumbersInput(winningNumbersInput);
            makeWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            inputWinningNumbers();
        }
    }

    public void makeWinningNumbers(String inputNumbers) {
        try {
            for (final String inputNumber : inputNumbers.split(",")) {
                validateInputNumber(inputNumber);
                final int number = Integer.parseInt(inputNumber);
                winningNumbers.add(number);
            }
            validateWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            inputWinningNumbers();
        }
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String bonusNumberInput = Console.readLine();
            validateBonusNumberInput(bonusNumberInput);
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            inputBonusNumber();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void validateWinningNumbersInput(String str) {
        if (!str.contains(",")) {
            System.out.println("[ERROR] 로또 당첨번호는 쉼표(,)로 구분하여 입력하여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 당첨번호는 쉼표(,)로 구분하여 입력하여야 합니다.");
        }
    }

    public void validateInputNumber(String winningNumbersInput) {
        if (!winningNumbersInput.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            System.out.println("[ERROR] 로또 당첨번호는 1부터 45까지의 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 당첨번호는 1부터 45까지의 숫자만 입력 가능합니다.");
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            System.out.println("[ERROR] 로또 당첨번호는 6개의 숫자로 이루어져야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 당첨번호는 6개의 숫자로 이루어져야 합니다.");
        }
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()){
            System.out.println("[ERROR] 로또 당첨번호에는 중복된 숫자를 포함하지 않아야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 당첨번호에는 중복된 숫자를 포함하지 않아야 합니다.");
        }
    }

    public void validateBonusNumberInput(String bonusNumberInput) {
        if (!bonusNumberInput.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            System.out.println("[ERROR] 로또 보너스번호는 1부터 45까지의 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 보너스번호는 1부터 45까지의 숫자만 입력 가능합니다.");
        }
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) {
            System.out.println("[ERROR] 로또 보너스번호는 당첨 번호를 제외한 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 보너스번호는 당첨 번호를 제외한 숫자만 입력 가능합니다.");
        }
    }
}
