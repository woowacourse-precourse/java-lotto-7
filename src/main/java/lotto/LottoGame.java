package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {

    private LottoStore lottoStore;

    public LottoGame() {
        this.lottoStore = new LottoStore();
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        printPurchaseBreakdown(lottos);
    }

    private List<Lotto> purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();

        int money = Integer.parseInt(rawMoney);
        return lottoStore.purchase(money);
    }

    private void printPurchaseBreakdown(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
