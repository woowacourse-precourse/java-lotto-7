package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> pickNewLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int purchaseCalculate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return money / 1000;
    }

    public void inputManager() {
        String input = Console.readLine();
        String[] numbersString = input.split(",");
        List<Integer> newNumbers = new ArrayList<Integer>();

        for (String number : numbersString) {
            try {
                newNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
            }
        }

        numbers.addAll(newNumbers);
    }
}
