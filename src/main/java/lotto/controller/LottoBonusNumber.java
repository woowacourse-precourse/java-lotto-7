package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.view.Input;

public class LottoBonusNumber {

    Input input = new Input();

    public int input() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return input.bonousNumber();

    }

}
