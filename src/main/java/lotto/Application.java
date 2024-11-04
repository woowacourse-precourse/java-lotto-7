package lotto;

import enums.Prize;
import functions.UserInput;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        UserInput userInput = new UserInput();

        int numberOfTickets = userInput.purchaseToNumberOfTickets();
        System.out.println();

        System.out.println(numberOfTickets + "개를 구매했습니다.");
        List<List<Integer>> tickets = lottoService.getTickets(numberOfTickets);
        System.out.println();

        Lotto winningNumber = userInput.winningNumber();
        System.out.println();

        int bonusNumber = userInput.bonusNumber(winningNumber.getNumbers());
        System.out.println();

        HashMap<String, Integer> lottoResult = lottoService.assessLottoOutcome(
                lottoService.getInitialLottoResult(), tickets, winningNumber,
                bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize rank : Prize.values()) {
            System.out.println(rank.getDescription() + lottoResult.get(rank.name()) + "개");
        }

        double rateOfReturn = lottoService.getRateOfReturn(lottoResult, numberOfTickets);
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + df.format(rateOfReturn) + "%입니다.");
    }
}
