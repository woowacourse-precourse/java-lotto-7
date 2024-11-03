package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.common.Validator;

public class InputView {
    private final static String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String QUANTITY_MESSAGE = "개를 구매했습니다.";
    private final static String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String getPrice() {
        System.out.println(PRICE_MESSAGE);
        String input = Console.readLine();
        return input.replaceAll(" ", "");
    }

    public void printLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + QUANTITY_MESSAGE);
    }

    public void printLottos(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public List<Integer> getWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBER_MESSAGE);
        while (true) {
            try {
                String input = Console.readLine();
                String trimmedInput = input.replaceAll(" ", "");
                validator.validateDelimiter(trimmedInput);
                return splitNumbers(trimmedInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitNumbers(String input) {
        return Optional.of(input)
                .filter(number -> number.contains(NUMBER_DELIMITER))
                .map(number -> Arrays.stream(number.split(NUMBER_DELIMITER))
                        .map(this::validateAndParse)
                        .toList())
                .orElseGet(() -> List.of(Integer.parseInt(input)));
    }

    private int validateAndParse(String input) {
        validator.isNumberInRange(input);
        return Integer.parseInt(input);
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return input.replaceAll(" ", "");
    }
}
