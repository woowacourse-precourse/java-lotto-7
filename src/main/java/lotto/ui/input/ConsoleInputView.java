package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.exception.InputException;
import lotto.ui.exception.InputExceptionMessage;
import lotto.ui.parser.InputParser;

import java.util.List;

public class ConsoleInputView implements InputView {

    private final InputParser inputParser = new InputParser();

    @Override
    public int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return inputParser.paymentAmount(input);
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return inputParser.inputToWinningNumbers(Console.readLine());
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
