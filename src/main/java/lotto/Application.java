package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Application {
    private static final String RESULT =
            """
			\n당첨 통계
			---
			3개 일치 (5,000원) - %s개
			4개 일치 (50,000원) - %s개
			5개 일치 (1,500,000원) - %s개
			5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
			6개 일치 (2,000,000,000원) - %s개
			총 수익률은 %.1f%%입니다.
			""";

    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        int money = repeatUntilNoException(Application::inputMoney());
        List<Lotto> lottos = shop.sell(money);

        System.out.println("\n%d개를 구매했습니다.".formatted(lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        List<Integer> winningNumbers = repeatUntilNoException(() -> inputWinningNumbers());
        int bonusNumber = repeatUntilNoException(() -> drawBonus(winningNumbers));

        LottoMachine machine = new LottoMachine();
        Result result = machine.informWinningResults(lottos, winningNumbers, bonusNumber, money);
        printResult(result);
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

    private static int drawBonus(List<Integer> winningNumbers) {
        int bonus = inputBonusNumber();
        InputValidator.validateBonusNotInWinningNumbers(winningNumbers, bonus);
        return bonus;
    }

    private static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요");
        String rawNumber = Console.readLine().trim();

        InputValidator.validateNumberInLottoRange(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    private static void printResult(Result result) {
        System.out.println(RESULT.formatted(
                result.fifth(),
                result.fifth(),
                result.third(),
                result.second(),
                result.first(),
                result.prizeRate()
        ));
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
