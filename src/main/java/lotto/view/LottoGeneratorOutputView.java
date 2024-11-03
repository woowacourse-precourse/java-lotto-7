package lotto.view;

import lotto.entity.Lotto;

import java.util.List;

public class LottoGeneratorOutputView implements OutputView{
    private final String OUTPUT_MESSAGE = "%d개를 구매했습니다.\n";
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
        System.out.printf(OUTPUT_MESSAGE, lottoList.size());
    }

    private void printLottoList(){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
