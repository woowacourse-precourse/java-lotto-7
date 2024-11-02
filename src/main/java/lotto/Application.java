package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    }
}
