package lotto.input;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber implements Input {

    private Lotto lotto;

    @Override
    public void validate(String input) {
        validateInput(input);
        List<Integer> list = new ArrayList<>();
        String[] split = input.split(",");

        for (String string : split) {
            list.add(Integer.parseInt(string));
        }

        lotto = new Lotto(list);
    }

    private void validateInput(String input) {
        if (!input.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식을 입력해주세요." +
                    "ex)1,2,3,4,5,6");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }
}
