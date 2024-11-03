package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.*;

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
                new InputNullCheck(input);
                new InputNumberCheck(input);

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
                new InputListNullCheck(winningInput);
                new InputListNumberCheck(winningInput);
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
                new InputNullCheck(input);
                new InputNumberCheck(input);

                int number = Integer.parseInt(input);

                return new Bonus(number);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
