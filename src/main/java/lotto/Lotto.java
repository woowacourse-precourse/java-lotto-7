package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberOfNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void printRequestingMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private int getMoneyInput() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }


}
