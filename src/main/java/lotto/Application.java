package lotto;

import camp.nextstep.edu.missionutils.Console;
import enums.Prize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        UserInput userInput = new UserInput();

        int numberOfTickets = userInput.numberOfTickets();
        System.out.println();

        System.out.println(numberOfTickets + "개를 구매했습니다.");
        List<List<Integer>> tickets = lottoService.getTickets(numberOfTickets);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberBeforeCheck = Console.readLine();
        Lotto winningNumber = new Lotto(lottoService.checkWinningNumber(winningNumberBeforeCheck));
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoService.checkBonusNumber(Console.readLine(),
                winningNumber.getNumbers());
        System.out.println();

        HashMap<String, Integer> lottoResult = lottoService.assessLottoOutcome(
                lottoService.getInitialLottoResult(), tickets, winningNumber.getNumbers(),
                bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize rank : Prize.values()) {
            System.out.println(rank.getDescription() + lottoResult.get(rank.name()) + "개");
        }
        double rateOfReturn = lottoService.getRateOfReturn(lottoResult, numberOfTickets);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
