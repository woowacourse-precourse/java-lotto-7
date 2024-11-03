package lotto.view;
import static lotto.domain.Constants.LOTTO_NUM_COUNT;
import static lotto.domain.Constants.SPLIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.validation.Validation;

public class Input {
    public int price() {
        System.out.print("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Lotto> number() {
        Validation validation = new Validation();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validation.number(input);
        String[] numberStrings = input.split(SPLIT);
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString.trim())); // 각 숫자를 정수로 변환 후 추가
        }
        Lotto lotto = new Lotto(numbers);

        List<Lotto> winningNumbers = new ArrayList<>();
        winningNumbers.add(lotto);
        return winningNumbers;
    }



}

