package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private LottoStore lottoStore;

    public LottoGame() {
        this.lottoStore = new LottoStore();
    }

    public void run() {
        int money = inputMoney();
        List<Lotto> lottos = lottoStore.purchase(money);
        printPurchaseBreakdown(lottos);

        List<Integer> winnerNumbers = inputWinnerNumbers();
        int bonusNumber = inputBonusNumber(winnerNumbers);

        List<LottoRank> lottoRanks = checkLottosRank(lottos, winnerNumbers, bonusNumber);
        double rateOfResult = LottoStatistics.calcRateOfReturn(money, lottoRanks);
        Map<LottoRank, Integer> rankMap = LottoStatistics.calcRankStatistics(lottoRanks);
    }

    private int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine();

        return Integer.parseInt(rawMoney);
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

    private void printRankBreakdown(Map<LottoRank, Integer> rankMap) {
        List<LottoRank> printLottoRanks = List.of(
                LottoRank.GRADE_5TH,
                LottoRank.GRADE_4TH,
                LottoRank.GRADE_3TH,
                LottoRank.GRADE_2TH,
                LottoRank.GRADE_1TH
        );

        for (LottoRank lottoRank : printLottoRanks) {
            System.out.printf("%s (%,d%s) - %d개\n",
                    lottoRank.getWinCondition(),
                    lottoRank.getPrizeMoney(),
                    LottoRank.UNIT,
                    rankMap.get(lottoRank)
            );
        }
    }
}
