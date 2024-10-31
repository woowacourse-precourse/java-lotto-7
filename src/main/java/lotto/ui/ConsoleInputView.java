package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.parser.InputParser;

import java.util.List;

public class ConsoleInputView implements InputView {

    private final InputParser inputParser;

    public ConsoleInputView(final InputParser lottoInputParser) {
        this.inputParser = lottoInputParser;
    }

    @Override
    public int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
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
