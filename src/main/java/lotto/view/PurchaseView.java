package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.purchase.Lotto;

public class PurchaseView {
    public String readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayPurchaseResult(final int lottoCount, final List<Lotto> purchasedLotto) {
        System.out.println();
        displayLottoCount(lottoCount);
        displayLottoTickets(purchasedLotto);
    }

    private void displayLottoCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    private void displayLottoTickets(final List<Lotto> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> {
            System.out.println(lottoTicket.getNumbers());
        });
    }
}
