package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        System.out.println("구입금액을 입력해 주세요.");
        String purchase = Console.readLine();
        System.out.println();

        int numberOfTickets = lottoService.getNumberOfTickets(purchase);
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

        Map<String, Integer> lottoResult = lottoService.assessLottoOutcome(
                lottoService.getInitialLottoResult(), tickets, winningNumber.getNumbers(),
                bonusNumber);

        // 추가 예정
    }
}
