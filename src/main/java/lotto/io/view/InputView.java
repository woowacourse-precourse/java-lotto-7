package lotto.io.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.Money;

public class InputView {

    private static final String AMOUNT_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_DELIM = ",";

    public Money getAmountOfMoney() {
        System.out.println(AMOUNT_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();

        return new Money(input);
    }

    public Lotto getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();
        List<Integer> winningNumbers = convertStringToList(input);

        return new Lotto(winningNumbers);
    }

    private List<Integer> convertStringToList(String input) {
        String[] numbers = input.split(INPUT_DELIM);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.strip()))
                .toList();
    }
}
