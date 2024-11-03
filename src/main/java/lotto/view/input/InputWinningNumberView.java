package lotto.view.input;

import java.util.List;
import lotto.parsers.Parser;

public class InputWinningNumberView extends InputView{
    public List<Integer> getValue() {
        System.out.println("당첨 번호를 입력해주세요.");
        String numbers = inputValue();
        validate(numbers);

        return Parser.parseStringToList(numbers);
    }

    private void validate(String numbers) {
        //숫자인지 검증
    }
}
