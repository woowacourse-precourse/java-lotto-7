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
    }

    private List<Lotto> purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();

        int money = Integer.parseInt(rawMoney);
        return lottoStore.purchase(money);
    }
}
