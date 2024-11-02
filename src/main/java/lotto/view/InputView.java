package lotto.view;

import static lotto.util.ErrorResponse.INVALID_BONUS_NUMBER;
import static lotto.util.ErrorResponse.INVALID_LOTTO_NUMBER;
import static lotto.util.PrintVariable.BONUS_NUM_INPUT;
import static lotto.util.PrintVariable.FIRST_BUY_MONEY_INPUT;
import static lotto.util.PrintVariable.LOTTO_NUM_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.SingletonObjectProvider;

public class InputView {

    private final OutputView outputView;

    public InputView() {
        this.outputView = SingletonObjectProvider.getSingletonObject(OutputView.class);
    }

    public Money inputMoney() {
        while (true) {
            try {
                outputView.printStringLineFeed(FIRST_BUY_MONEY_INPUT.value());
                return Money.from(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputOwnLotto() {
        while (true) {
            try {
                outputView.printStringLineFeed(LOTTO_NUM_INPUT.value());
                String input = Console.readLine();
                validateLottoInput(input);

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .toList();

                return Lotto.from(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateLottoInput(String input) {
        String[] inputNumbers = input.split(",");

        // 입력값이 숫자인지 체크
        if (Arrays.stream(inputNumbers).anyMatch(s -> !s.matches("[0-9]+"))) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                outputView.printStringLineFeed("\n".concat(BONUS_NUM_INPUT.value()));
                String num = Console.readLine();

                if (!num.matches("[0-9]+")) {
                    throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
                }
                if (Integer.parseInt(num) < 1 || Integer.parseInt(num) > 45) {
                    throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
                }

                return Integer.parseInt(num);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
