package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.exception.InputException;
import lotto.ui.exception.InputExceptionMessage;
import lotto.ui.parser.InputParser;

import java.util.List;

public class ConsoleInputView implements InputView {

    private final InputParser inputParser;

    public ConsoleInputView(final InputParser lottoInputParser) {
        this.inputParser = lottoInputParser;
    }

    @Override
    public int inputPayment() {
        do {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new InputException(InputExceptionMessage.INVALID_NUMBER_FORMAT);
            }
        } while (true);
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
