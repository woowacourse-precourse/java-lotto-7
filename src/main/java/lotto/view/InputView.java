package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final SimpleInputValidator validator;

    public InputView(SimpleInputValidator validator) {
        this.validator = validator;
    }

    public Long inputAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = readLine();

                validator.isNumber(input);
                return Long.parseLong(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String notSplitWinningNumbers = readLine();
                validator.validateWinningNumber(notSplitWinningNumbers);
                return numbersToInteger(notSplitWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> numbersToInteger(String notSplitWinningNumbers) {
        String[] stringWinningNumbers = notSplitWinningNumbers.split(",");
        return Arrays.stream(stringWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonuseNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = readLine();
                validator.isNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
