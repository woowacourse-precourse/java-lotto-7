package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    private List<String> winningInput;
    private List<Integer> winningNumbers;
    private int number;
    private int bonusNumber;

    public int inputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                nullCheck(input);
                isNumber(input);
                int money = Integer.parseInt(input);
                moneyValidate(money);
                number = money / 1000;

                return number;

            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningInput = List.of(Console.readLine().split(","));
                nullCheck(winningInput);
                isNumber(winningInput);
                winningNumbers = winningInput.stream().map(Integer::parseInt).collect(Collectors.toList());
                isRange(winningNumbers);
                isSix(winningNumbers);

                return winningNumbers;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                nullCheck(input);
                isNumber(input);
                bonusNumber = Integer.parseInt(input);
                isRange(bonusNumber);

                return bonusNumber;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void nullCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다. 입력해 주세요.");
        }
    }

    private void nullCheck(List<String> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다. 입력해 주세요.");
        }
    }

    private void moneyValidate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요");
        }
    }

    private void isNumber(String input) {
        boolean isNum = input.matches("[+-]?\\d*(\\.\\d+)?");

        if(!isNum) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void isRange(int input) {
        if (!(1 <= input && input <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 수만 입력해주세요.");
        }
    }

    private void isNumber(List<String> winningInput) {
        for (String input : winningInput) {
            boolean num = input.matches("[+-]?\\d*(\\.\\d+)?");

            if(!num) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    private void isRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    private void isSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getNumber() {
        return number;
    }

    public int getBonus() {
        return bonusNumber;
    }
}
