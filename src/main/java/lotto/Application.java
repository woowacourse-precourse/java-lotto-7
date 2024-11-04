package lotto;

import static lotto.LottoRank.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Application {
    private static final LottoMachine lottoMachine = new LottoMachineImpl();

    public static void main(String[] args) {
        List<Lotto> lottoTickets = purchaseLottoTickets();
        showCreateLottoTickets(lottoTickets);

        HashMap<LottoRank, Integer> winningResult = getWinningResult(lottoTickets);
        showWinningResult(winningResult);

        calculateProfitRate(winningResult, lottoTickets.size());
    }

    static private List<Lotto> purchaseLottoTickets() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchaseMoney = Console.readLine();

                return lottoMachine.purchaseLottoTickets(purchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static private HashMap<LottoRank, Integer> getWinningResult(List<Lotto> lottoTickets) {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbers = Console.readLine();
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();

                return lottoMachine.getWinningResult(lottoTickets, winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static private void calculateProfitRate(HashMap<LottoRank, Integer> winningResult, int purchaseNumber) {
        Double profitRate = lottoMachine.calculateProfitRate(winningResult, purchaseNumber);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    static private void showCreateLottoTickets(List<Lotto> lottoTickets) {
        System.out.println("\n" + lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    static private void showWinningResult(HashMap<LottoRank, Integer> winningResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.get(RANK_5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.get(RANK_4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(RANK_3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(RANK_2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(RANK_1) + "개");
    }
}
