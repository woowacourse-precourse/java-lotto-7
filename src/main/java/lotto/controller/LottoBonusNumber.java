package lotto.controller;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.Input;

public class LottoBonusNumber {
    Input input = new Input();

    public int input(List<Integer> winnigNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return input.bonousNumber(winnigNumbers);
    }

}
