package lotto.view;

import lotto.domain.PurchaseLotto;
import lotto.message.OutputMessage;

import java.util.List;

public class OutputView {

    public void purchaseLottoView(int lottoTickets, List<PurchaseLotto> purchaseLottos){
        System.out.println("\n" + lottoTickets + OutputMessage.PURCHASE_LOTTO.getMessage());
        for(PurchaseLotto purchaseLotto : purchaseLottos){
            System.out.println(purchaseLotto.getLottoNumbers());
        }
    }
}
