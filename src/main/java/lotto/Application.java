package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachineImpl();
        String purchaseMoney;
        List<Lotto> lottoTickets;
        HashMap<LottoRank, Integer> winningResult;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseMoney = Console.readLine();
                lottoTickets = lottoMachine.purchaseLottoTickets(purchaseMoney);
                showCreateLottoTickets(lottoTickets);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e. getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbers = Console.readLine();
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();
                winningResult = lottoMachine.getWinningResult(lottoTickets, winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Double profitRate = lottoMachine.calculateProfitRate(winningResult, purchaseMoney);
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
