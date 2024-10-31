package lotto.view.output;

import lotto.domain.Lotto;

import java.util.List;

public class LottoOutputView {

    public void printMoneyInput() {
        System.out.println(OutputMessage.MONEY_INPUT_MESSAGE);
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {

        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", lottoBundle.size()));
        lottoBundle.stream().forEach(lotto -> System.out.println(lotto));
    }

}