package lotto;

import java.util.ArrayList;
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

    private int countCalculator(String input) {
        int money = integerParser(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
        }

        return money / 1000;
    }

    private int integerParser(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
        }
    }

    public void moneyInput() {
        printGuide("구입금액을 입력해 주세요.");
        int cnt = countCalculator(Console.readLine());

    }

    public void numbersInput() {
        printGuide("당첨 번호를 입력해 주세요.");
        saveNumbers(Console.readLine());
    }

    public void bonusInput() {
        printGuide("보너스 번호를 입력해 주세요.");
        saveNumbers(Console.readLine());

    }

    private void saveNumbers(String input) {
        String[] numbersString = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbersString) {
            int numberInt = integerParser(number);
            winningNumbers.add(numberInt);
        }

        validate(winningNumbers);
        numbers.addAll(winningNumbers);
    }

    public void printNewLotto(int cnt) {
        printGuide(cnt + "개를 구매했습니다.");

    }

    public void printGuide(String message) {
        System.out.println(message);
    }
}
