package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public Cash inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        String price = Console.readLine();

        inputValidator.validateNumeric(price);

        return new Cash(Integer.parseInt(price));
    }

    public WinningNumbers inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String numbers = Console.readLine();

        inputValidator.validateNumbersByComma(numbers);

        return new WinningNumbers(
            Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList()
        );
    }
}
