package lotto.view;

import lotto.domain.PurchaseLotto;

public class OutputView {

    public static void printPurchaseInputText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedCount(PurchaseLotto purchaseLotto) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseLotto.getLottoCount());
    }

    public static void printPurchasedLottoTickets(PurchaseLotto purchaseLotto) {
        StringBuilder lottoTickets = new StringBuilder();
        purchaseLotto.getTickets().stream()
                .forEach(lotto -> lottoTickets.append("\n"));;
        System.out.println(lottoTickets);
    }
}
