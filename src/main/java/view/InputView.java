package view;

import camp.nextstep.edu.missionutils.Console;
import common.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validator.InputValidator;

public class InputView {

    public int inputLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String LottoPurchaseAmount = Console.readLine();
                if (InputValidator.validatePurchaseAmount(LottoPurchaseAmount)) {
                    return Integer.parseInt(LottoPurchaseAmount);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public List<Integer> inputWinnerLottoNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해주세요.");
                String input = Console.readLine();

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (InputValidator.validateWinnerLottoNumbers(numbers)){
                    return numbers;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());

                if (InputValidator.validateBonusNumber(bonusNumber))
                    return bonusNumber;

            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERROR_INVALID_NUMBER_FORMAT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
