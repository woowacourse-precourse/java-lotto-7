package lotto.view.output;

import lotto.entity.Lotto;
import lotto.enums.OutputMessage;

import java.util.List;

public class LottoGeneratorOutputView implements OutputView {
    private final List<Lotto> lottoList;

    public LottoGeneratorOutputView(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    @Override
    public void print() {
        printLottoListSize();
        printLottoList();
    }

    private void printLottoListSize(){
        System.out.printf(OutputMessage.LOTTO_COUNT.getMessage(), lottoList.size());
    }

    private void printLottoList(){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }

        System.out.println();
    }
}
