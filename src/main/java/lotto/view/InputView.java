package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.PositiveNumber;
import lotto.exception.ErrorMessage;

public class InputView {

    private static final String DELIMITER = ",";

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public PositiveNumber getPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                long price = Long.parseLong(Console.readLine());
                inputValidator.validateDivisibleByThousand(price);
                return new PositiveNumber(price);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_DATA_TYPE.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumberRequestDto getEntireNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        return new WinningNumberRequestDto(winningNumbers, getBonusNumber(winningNumbers));
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> numbers = Arrays.stream(Console.readLine().split(DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
                inputValidator.validateIsSizeSix(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_DATA_TYPE.get());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                inputValidator.validateIsIn(winningNumbers, bonusNumber);
                inputValidator.validateIsInBound(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_DATA_TYPE.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
