package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Application {
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        int money = repeatUntilNoException(() -> inputMoney());
        List<Lotto> lottos = shop.sell(money);
        printLottos(lottos);

        List<Integer> winningNumbers = repeatUntilNoException(() -> inputWinningNumbers());
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine().trim();

        InputValidator.validateNaturalNumber(rawMoney);
        int money = Integer.parseInt(rawMoney);

        InputValidator.validateLottoAmountUnit(money);
        InputValidator.validateMaxPurchaseAmount(money);

        return Integer.parseInt(rawMoney);
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String rawInput = Console.readLine().trim();

        InputValidator.validateContainsDelimiter(rawInput);
        String[] splitInputs = rawInput.split(DELIMITER);

        List<Integer> numbers = parseNumbers(splitInputs);

        InputValidator.validateSixNumbers(numbers);
        InputValidator.validateWinningNumbersDuplicate(numbers);

        return numbers;
    }

    private static List<Integer> parseNumbers(String[] splitInputs) {
        return Arrays.stream(splitInputs)
                .map(String::trim)
                .map(input -> {
                    InputValidator.validateNumberInLottoRange(input);
                    return Integer.parseInt(input);
                })
                .toList();
    }

    private static <T> T repeatUntilNoException(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
