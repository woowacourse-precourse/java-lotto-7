package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        System.out.println("구입금액을 입력해 주세요.");
        String purchase = Console.readLine();

        int numberOfTickets = lottoService.getNumberOfTickets(purchase);

        List<List<Integer>> tickets = lottoService.getTickets(numberOfTickets);

        // 추가 예정
    }
}
