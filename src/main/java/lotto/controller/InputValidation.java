package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.View;

public class InputValidation {
    private static View view;

    public InputValidation() {
        view = new View();
    }

    public Long getValidatedMoney() {
        while (true) {
            try {
                return moneyCheck();
            } catch (Exception e) {
                System.out.println(e.getMessage()); // 모든 예외를 한 번에 처리
            }
        }
    }

    private Long moneyCheck() {
        String moneyInput = view.getMoneyInput().replace(" ", "");
        checkInputNull(moneyInput);
        checkMoneyForm(moneyInput);
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

    public void checkMoneyForm(String input) {
        if (!input.matches("\\d+")) { // 숫자로만 이루어졌는지 확인
            throw new IllegalArgumentException("[ERROR] 금액은 숫자(양수)만 입력 가능합니다.");
        }
    }


    public List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                return winningNumbersCheck();
            } catch (Exception e) {
                System.out.println(e.getMessage()); // 모든 예외를 한 번에 처리
            }
        }
    }

    private List<Integer> winningNumbersCheck() {
        String winningNumbersInput = view.getWinningNumbers().replace(" ", "");
        checkInputNull(winningNumbersInput);
        checkWinningNumbersForm(winningNumbersInput);
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(",")).map(Integer::parseInt).toList();
        checkNumbersRange(winningNumbers);
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

}
