package lotto.view;
import static lotto.domain.Constants.SPLIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.Validation;

public class Input {
    public int price() {
        System.out.print("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    Validation validation = new Validation();
    List<Integer> numbers = new ArrayList<>();

    public List<Lotto> winningNumber() {
        String input = Console.readLine();
        validation.number(input);
        validation.duplicatedNumber(input);
        String[] numberStrings = input.split(SPLIT);

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim())); // 각 숫자를 정수로 변환 후 추가
        }
        Lotto lotto = new Lotto(numbers);
        List<Lotto> Numbers = new ArrayList<>();
        Numbers.add(lotto);
        return Numbers;
    }

    public int bonousNumber(List<Lotto> numbers) {
        String input = Console.readLine();
        validation.number(input);
        validation.duplicatedBonous(input, numbers);
        return Integer.parseInt(input.trim());
    }
}

