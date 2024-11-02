package lotto;

import java.util.List;
import java.util.Scanner;

public class LottoMachine {
    private final LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        try {
            PurchaseValidator.validate(purchaseAmount);
            int ticketCount = purchaseAmount / 1000;
            List<Lotto> purchasedTickets = ticketGenerator.generateTickets(ticketCount);

            System.out.printf("%d개를 구매했습니다.\n", ticketCount);

            // 추가 로직: 당첨 번호와 보너스 번호 입력 및 당첨 결과 출력

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
