package lotto.domain.view;

import lotto.domain.model.Lotto;

import java.util.List;

import static lotto.common.constant.PrintFormatConst.*;


public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_PURCHASE_COUNT_FORMAT, lottos.size());
        lottos.stream()
                .map(Lotto::print)
                .forEach(System.out::println);
    }
}
