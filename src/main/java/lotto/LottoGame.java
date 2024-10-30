package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private LottoStore lottoStore;

    public LottoGame() {
        this.lottoStore = new LottoStore();
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        printPurchaseBreakdown(lottos);

        List<Integer> winnerNumbers = inputWinnerNumbers();
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

    private List<Integer> inputWinnerNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numberMass = Console.readLine();
        String[] rawNumbers = numberMass.split(",");

        return Arrays.stream(rawNumbers)
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
    }
}
