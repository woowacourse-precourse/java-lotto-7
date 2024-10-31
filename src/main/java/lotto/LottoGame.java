package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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
        int bonusNumber = inputBonusNumber(winnerNumbers);

        List<LottoRank> lottoRanks = checkLottosRank(lottos, winnerNumbers, bonusNumber);
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

    private int inputBonusNumber(List<Integer> winnerNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String rawBonusNumber = Console.readLine();

        return Integer.parseInt(rawBonusNumber);
    }

    private List<LottoRank> checkLottosRank(List<Lotto> lottos, List<Integer> winnerNumbers, int bonus) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.checkRank(winnerNumbers, bonus);
            lottoRanks.add(lottoRank);
        }

        return lottoRanks;
    }
}
