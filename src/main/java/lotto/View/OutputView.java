package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoNum(List<Lotto> numbers) {

        for (Lotto lotto : numbers) {
            lotto.print();
        }

    }

}
