package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachineImpl();
        
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseMoney = Console.readLine();
        List<Lotto> lottoTickets = lottoMachine.createLottoTickets(purchaseMoney);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        HashMap<LottoRank, Integer> winningResult =
                lottoMachine.getWinningResult(lottoTickets, winningNumbers, bonusNumber);

        Double profitRate = lottoMachine.calculateProfitRate(winningResult, purchaseMoney);
        System.out.println("총 수익률은 "+ profitRate + "%입니다.");
    }
}
