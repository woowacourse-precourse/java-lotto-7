package lotto.input;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber implements Input {

    private Lotto lotto;

    @Override
    public void validate(String input) {
        List<Integer> list = new ArrayList<>();
        String[] split = input.split(",");

        for (String string : split) {
            list.add(Integer.parseInt(string));
        }

        lotto = new Lotto(list);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
