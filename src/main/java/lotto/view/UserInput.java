package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.Bonus;
import lotto.service.Lotto;
import lotto.service.Money;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    private List<String> winningInput;
    private List<Integer> winningNumbers;

    public Money inputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                nullCheck(input);
                isNumber(input);
                int number = Integer.parseInt(input);

                return new Money(number);
            } catch (IllegalArgumentException e) {
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

                Lotto lotto = new Lotto(winningNumbers);

                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Bonus inputBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                nullCheck(input);
                isNumber(input);

                int number = Integer.parseInt(input);

                return new Bonus(number);

            } catch (IllegalArgumentException e) {
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


    private void isNumber(String input) {
        boolean isNum = input.matches("[+-]?\\d*(\\.\\d+)?");

        if (!isNum) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }


    private void isNumber(List<String> winningInput) {
        for (String input : winningInput) {
            boolean num = input.matches("[+-]?\\d*(\\.\\d+)?");

            if (!num) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
