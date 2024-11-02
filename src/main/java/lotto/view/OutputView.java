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
                .forEach(lotto -> lottoTickets.append(lotto).append("\n"));
        System.out.println(lottoTickets);
    }

    public static void printWinningNumberInputText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputText() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
