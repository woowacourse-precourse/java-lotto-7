package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.Input;

public class LottoWinningNumber {
    Input input = new Input();

    public List<Integer> input() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return input.winningNumber();
    }
}
