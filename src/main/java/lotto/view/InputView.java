package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.parser.InputParser;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputParser.parseInteger(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return inputParser.parseWinningNumbers(Console.readLine());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return inputParser.parseInteger(Console.readLine());
    }

}
