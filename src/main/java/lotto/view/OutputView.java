package lotto.view;

import lotto.model.Lottos;
import lotto.util.OutputMessage;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println();
        int lottoSize = lottos.getLottosSize();
        System.out.println(lottoSize + OutputMessage.SUCCESS_TICKET_PURCHASE);
        for(int i = 0; i < lottoSize; i++) {
            System.out.println(lottos.getLotto(i).getNumbers());
        }
        System.out.println();
    }
}
