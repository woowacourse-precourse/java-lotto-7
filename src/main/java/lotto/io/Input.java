package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String DELIMITER = ",";
    private final String ERROR_LOG = "[ERROR] ";
    private final String INVALID_NUMBER_FORMAT = "올바른 숫자가 아닙니다";

    public Input() {

    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int number = inputNumber();
        System.out.println();
        return number;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> parsingNumbers = inputAndParsingNumbers();
        System.out.println();
        return parsingNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputNumber = inputNumber();
        System.out.println();
        return inputNumber;
    }

    private int inputNumber() {
        while (true) {
            String inputString = Console.readLine();
            int number = 0;
            try {
                number = Integer.parseInt(inputString);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_LOG + INVALID_NUMBER_FORMAT);
            }
        }

    }

    private List<Integer> inputAndParsingNumbers() {
        String inputString = Console.readLine();
        String[] strings = inputString.split(DELIMITER);
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .toList();
    }
}
