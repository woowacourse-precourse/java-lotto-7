package lotto.view.impl;

import static lotto.constant.GameMessage.BOUGHT_LOTTO_MESSAGE;

import java.util.List;
import lotto.Lotto;
import lotto.view.OutPutView;

public class OutViewImpl implements OutPutView {
    @Override
    public void printBoughtLotto(List<Lotto> boughtLotto) {
        BOUGHT_LOTTO_MESSAGE.printGameMessage(boughtLotto.size());
        boughtLotto.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
