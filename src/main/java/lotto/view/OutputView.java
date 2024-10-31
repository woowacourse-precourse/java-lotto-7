package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.PrintMessage;

public class OutputView {
    public void printLottoList(List<Lotto> lotteries){
        System.out.println(PrintMessage.OUTPUT_LOTTO_LIST.format(lotteries.size()));
        for(Lotto lotto : lotteries){
            System.out.println(lotto.getNumbers());
        }
    }
}
