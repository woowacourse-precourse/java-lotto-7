package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoParser;
import lotto.Purchase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputHandler {

    private static final String ORDER_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    private static Lotto inputLottoNumber(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(LottoParser::parseNumber)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static Lotto repeatInputLottoNumber() {
        return repeatInput(InputHandler::inputLottoNumber, LOTTO_NUMBER_INPUT_MESSAGE);
    }

    private static Purchase inputOrderPrice(String input) {
        try {
            int price = Integer.parseInt(input);
            return new Purchase(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 수를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static Purchase repeatInputOrderPrice() {
        return repeatInput(InputHandler::inputOrderPrice, ORDER_AMOUNT_INPUT_MESSAGE);
    }

    private static <T> T repeatInput(Function<String, T> parser, String message) {
        while(true) {
            try {
                String input = getInput(message);
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static String getInput(String message) {
        System.out.println(message);
        return Console.readLine().trim();
    }
}
