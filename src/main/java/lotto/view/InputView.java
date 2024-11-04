package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.InputValidator;
import lotto.domain.LottoPrize;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int inputPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                return validateAndParseMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LottoPrize inputLottoPrize() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String inputPrizeNumbers = Console.readLine();
                List<Integer> prizeNumbers = validateAndParseLottoNumbers(inputPrizeNumbers);

                System.out.println("\n보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                int bonusNumber = inputValidator.validateAndParseNumber(inputBonusNumber);

                return new LottoPrize(prizeNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAndParseMoney(String input) {
        inputValidator.validateEmpty(input);

        int money = inputValidator.validateAndParseNumber(input);
        inputValidator.validatePurchaseAmount(money);

        return money;
    }

    private List<Integer> validateAndParseLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(inputValidator::validateAndParseNumber)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
