package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Parser;
import lotto.Purchase;

import java.util.function.Function;

public class InputHandler {

    private static final String ORDER_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static Lotto repeatInputLottoNumber() {
        return repeatInput(Parser::parseLottoNumber, LOTTO_NUMBER_INPUT_MESSAGE);
    }

    public static Purchase repeatInputOrderPrice() {
        return repeatInput(Parser::parsePurchase, ORDER_AMOUNT_INPUT_MESSAGE);
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
