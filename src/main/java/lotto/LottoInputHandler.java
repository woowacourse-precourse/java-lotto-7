package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputHandler {
    private static final String NUMBER_DELIMITER = ",";

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (예: 1,2,3,4,5,6)");
                String input = Console.readLine();
                List<Integer> numbers = parseNumbers(input);
                LottoValidator.validateWinningNumbers(numbers);
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

