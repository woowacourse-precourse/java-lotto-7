package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Application {
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        int money = repeatUntilSuccess(Application::inputMoney);
        List<Lotto> lottos = shop.sell(money);

        System.out.println("\n%d개를 구매했습니다.".formatted(lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        List<Integer> winningNumbers = repeatUntilSuccess(Application::drawWinningNumbers);
        int bonusNumber = repeatUntilSuccess(() -> drawBonus(winningNumbers));

        LottoMachine machine = new LottoMachine(winningNumbers, bonusNumber);
        Result result = machine.check(lottos, money);
        System.out.println(result.formatted());
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine().trim();

        InputValidator.validateNaturalNumber(rawMoney);
        int money = Integer.parseInt(rawMoney);

        InputValidator.validatePurchasable(money);

        return Integer.parseInt(rawMoney);
    }

    private static List<Integer> drawWinningNumbers() {
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

    private static int drawBonus(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요");
        String rawNumber = Console.readLine().trim();

        InputValidator.validateNumberInLottoRange(rawNumber);

        int bonus = Integer.parseInt(rawNumber);
        InputValidator.validateBonusNotInWinningNumbers(winningNumbers, bonus);
        return bonus;
    }

    private static <T> T repeatUntilSuccess(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
