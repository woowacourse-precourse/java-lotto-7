package lotto.domain;

import java.util.List;

public class LottoTicket {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void showLottoTicket() {
        showPurchaseMessage();
        showLottoNumbers();
    }

    private void showPurchaseMessage() {
        System.out.printf(PURCHASE_MESSAGE, lottos.size());
    }

    private void showLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }



}
