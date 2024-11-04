package lotto.view;

import static lotto.domain.Constants.SPLIT;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.Validation;

public class Input {
    public int price() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    Validation validation = new Validation();
    List<Integer> numbers = new ArrayList<>();
    Lotto lotto;

    public List<Integer> winningNumber() throws IllegalArgumentException{
        String input = Console.readLine();
        validation.number(input);
        validation.duplicatedNumber(input);

        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(SPLIT);

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim()));
        }

        lotto = new Lotto(numbers);
        return numbers;
    }

    public int bonousNumber(List<Integer> numbers) {
        String input = Console.readLine();
        validation.number(input);
        validation.duplicatedBonous(input, numbers);
        return Integer.parseInt(input.trim());
    }
}

