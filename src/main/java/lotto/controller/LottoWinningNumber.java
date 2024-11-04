package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.Input;

public class LottoWinningNumber {
    Input input = new Input();

    public List<Lotto> input() {
        System.out.println();
        System.out.print("당첨 번호를 입력해 주세요.");
        return input.winningNumber();
    }
}
