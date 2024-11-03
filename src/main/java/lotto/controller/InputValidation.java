package lotto.controller;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;

public class InputValidation {
    private static InputView inputView;

    public InputValidation() {
        inputView = new InputView();
    }

    public Long getValidatedMoney() {
        while (true) {
            try {
                return moneyCheck();
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Long moneyCheck() {
        String moneyInput = inputView.getMoneyInput().replace(" ", "");
        checkInputNull(moneyInput);
        checkNumberForm(moneyInput);
        Long money = Long.parseLong(moneyInput);
        checkUnitOfMoney(money);
        return money;
    }

    public void checkInputNull(String input) {
        if (input.isEmpty()){
            throw new NullPointerException("[ERROR] 금액을 비워둘 수 없습니다");
        }
    }

    public void checkUnitOfMoney(Long input) {
        if (input == 0 || !(input%1000==0)){
            throw new IllegalArgumentException("[ERROR] 금액은 0원이 될 수 없고, 1000원 단위로만 입력 가능합니다.");
        }
    }

    public void checkNumberForm(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자(양수)만 입력 가능합니다.");
        }
    }


    public List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                return winningNumbersCheck();
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> winningNumbersCheck() {
        String winningNumbersInput = inputView.getWinningNumbers().replace(" ", "");
        checkInputNull(winningNumbersInput);
        checkWinningNumbersForm(winningNumbersInput);
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(",")).map(Integer::parseInt).toList();
        checkNumbersRange(winningNumbers);
        checkUniqueNumbers(winningNumbers);
        return winningNumbers;
    }

    public void checkWinningNumbersForm(String input) {
        if (!input.matches("^\\d{1,2}(,\\d{1,2}){5}$")) {
            throw new IllegalArgumentException("[ERROR] 입력은 쉼표로 구분된 6개의 양수로 이루어져야 합니다.");
        }
    }

    public void checkNumbersRange(List<Integer> inputNumbers) {
        for (int number : inputNumbers) {
            if (number<1 || number>45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 번호여야 합니다.");
            }
        }
    }

    public void checkUniqueNumbers(List<Integer> inputNumbers) {
        boolean hasDuplicate = inputNumbers.stream().distinct().count() != inputNumbers.size();
        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public Integer getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return bonusNumberCheck(winningNumbers);
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer bonusNumberCheck(List<Integer> winningNumbers) {
        String bonusNumbersInput = inputView.getBonusNumber().replace(" ", "");
        checkInputNull(bonusNumbersInput);
        checkNumberForm(bonusNumbersInput);
        Integer bonusNumber = parseInt(bonusNumbersInput);
        checkNumbersRange(List.of(bonusNumber));
        checkUniqueBetweenWinningAndBonus(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    public void checkUniqueBetweenWinningAndBonus(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer number : winningNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다");
            }
        }
    }
}


