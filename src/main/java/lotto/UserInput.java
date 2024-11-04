package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    LottoService lottoService = new LottoService();

    public int numberOfTickets() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchase = Console.readLine();

            try {
                return lottoService.getNumberOfTickets(purchase);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

    public Lotto winningNumber() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumberBeforeCheck = Console.readLine();

            try {
               return new Lotto(lottoService.checkWinningNumber(winningNumberBeforeCheck));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

}
