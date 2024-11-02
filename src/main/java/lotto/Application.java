package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        System.out.println("구입금액을 입력해 주세요.");
        String purchase = Console.readLine();

        int numberOfTickets = lottoService.getNumberOfTickets(purchase);

        System.out.println(numberOfTickets);

    }
}
