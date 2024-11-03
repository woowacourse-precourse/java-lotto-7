package lotto;

public class OutputView {

    public void printLottoPurchaseDetails(Lottos lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.getCount());
        System.out.printf("%s", lottos.toString());
    }

}
