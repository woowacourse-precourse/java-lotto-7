package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class InputReader {

    private final InputValidator inputValidator;

    public InputReader(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return inputValidator.validateAmount(input);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return inputValidator.validateWinningNumbers(input);
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        return inputValidator.validateBonusNumber(input);
    }


}
