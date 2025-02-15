package lotto.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.view.InputView;

public class InputProcessor {

    private static final String INPUT_DELIM = ",";

    private final InputView inputView = new InputView();

    public Money createMoney() {
        Money money;
        while (true) {
            try {
                String input = inputView.getAmountOfMoney();
                int amountOfMoney = Integer.parseInt(input);
                money = new Money(amountOfMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return money;
    }

    public WinningInfo createWinningInfo() {
        Lotto winningNumbers = createWinningNumbers();
        WinningInfo winningInfo;
        while (true) {
            try {
                BonusNumber bonusNumber = createBonusNumber();
                winningInfo = new WinningInfo(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningInfo;
    }

    private Lotto createWinningNumbers() {
        Lotto winningNumbers;
        while (true) {
            try {
                String input = inputView.getWinningNumbers();
                List<Integer> numbers = convertStringToList(input);
                winningNumbers = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    private BonusNumber createBonusNumber() {
        BonusNumber bonusNumber;
        while (true) {
            try {
                String input = inputView.getBonusNumber();
                int number = Integer.parseInt(input);
                bonusNumber = new BonusNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private List<Integer> convertStringToList(String input) {
        String[] numbers = input.split(INPUT_DELIM);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.strip()))
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}
