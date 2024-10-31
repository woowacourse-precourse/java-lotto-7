package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.PrintMessage;

public class OutputView {
    public void printLottoList(List<Lotto> lottos){
        System.out.println(PrintMessage.OUTPUT_LOTTO_LIST.format(lottos.size()));
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
