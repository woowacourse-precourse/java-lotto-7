package lotto.view.output;

import lotto.entity.Lotto;
import lotto.enums.OutputMessage;

import java.util.List;

public class LottoGeneratorOutputView implements OutputView {
    private final List<Lotto> lottos;

    public LottoGeneratorOutputView(List<Lotto> lottoList){
        this.lottos = lottoList;
    }

    @Override
    public void print() {
        printLottoListSize();
        printLottoList();
    }

    private void printLottoListSize(){
        System.out.printf(OutputMessage.LOTTO_COUNT.getMessage(), lottos.size());
    }

    private void printLottoList(){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }

        System.out.println();
    }
}
