package lotto.view;

import static lotto.util.ParserUtil.parseInt;
import static lotto.util.ParserUtil.parseWinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {
    public int inputToParsed() {
        return parseInt(input());
    }

    public Lotto setWinningNumber() {
        String input = input();
        List<Integer> valueOfWinningNumber = parseWinningNumbers(input);
        return new Lotto(valueOfWinningNumber);
    }

    private String input() {
        return Console.readLine();
    }
}
