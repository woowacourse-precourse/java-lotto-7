package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.model.BonusNumber;
import lotto.model.Cost;
import lotto.model.Lotto;

public class InputView {

    public int getCost() {
        return Cost.from(Integer.parseInt(Console.readLine().trim())).getCost();
    }

    public Lotto getLottoNumber() {
        return new Lotto(Arrays.stream(Console.readLine().trim().split(","))
                .map(Integer::parseInt)
                .toList());
    }

    public int getBonusNumber(Lotto lotto) {
        return BonusNumber.of(Integer.parseInt(Console.readLine().trim()), lotto).getBonusNumber();
    }


}
