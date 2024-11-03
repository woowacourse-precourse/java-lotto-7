package lotto.view.input;

import java.util.List;
import lotto.parsers.Parser;

public class InputWinningNumberView extends InputView {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해주세요.";

    public List<Integer> getValue() {
        System.out.println(INPUT_MESSAGE);
        String numbers = inputValue();

        return Parser.parseStringToList(numbers);
    }
}
