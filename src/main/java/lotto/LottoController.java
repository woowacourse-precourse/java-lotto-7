package lotto;

import java.util.List;

public class LottoController {
    private LottoView view;
    private LottoLogic logic;

    public LottoController(LottoView view, LottoLogic logic) {
        this.view = view;
        this.logic = logic;
    }

    public void run() {
        buyLottos();
        
    }

    private void buyLottos() {
        while (true) {
            try {
                int purchaseAmount = view.readPurchaseAmount();
                List<Lotto> lottos = logic.issueLottoAsPrice(purchaseAmount);

                int purchaseCount = logic.getTicketCount(purchaseAmount);
                view.printIssuedLottos(purchaseCount, lottos);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
    
}
