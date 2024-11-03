package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.view.Input;

public class LottoWinningNumber {
    Input input = new Input();

    public List<Lotto> input() {
        return input.winningNumber();
    }
}
