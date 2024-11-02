package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Application {
    private static final LottoMachine lottoMachine = new LottoMachineImpl();

    public static void main(String[] args) {
        List<Lotto> lottoTickets = purchaseLottoTickets();

        HashMap<LottoRank, Integer> winningResult = getWinningResult(lottoTickets);

        calculateProfitRate(winningResult, lottoTickets.size());
    }

    static private List<Lotto> purchaseLottoTickets() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchaseMoney = Console.readLine();

                List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(purchaseMoney);
                showCreateLottoTickets(lottoTickets);
                return lottoTickets;
            } catch (IllegalArgumentException e) {
                System.out.println(e. getMessage());
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
        System.out.println("총 수익률은 "+ profitRate + "%입니다.");
    }

    static private void showCreateLottoTickets(List<Lotto> lottoTickets) {
        System.out.println("\n" + lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
