package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.vo.Number;

public class WinningNumber extends Lotto {

    private Number bonusNumber;

    public WinningNumber(List<Integer> numbers, int number) {
        super(numbers);
        this.bonusNumber = new Number(number);
    }
}
