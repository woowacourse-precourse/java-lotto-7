package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryStore {

    static LottoTickets purchase() {
        int numberOfLottoTicket = inputSpending();
        System.out.println();

        LottoTickets tickets = new LottoTickets();

        for(int i = 0; i < numberOfLottoTicket; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            LottoTicket ticket = new LottoTicket(randomNumbers);
            tickets.add(ticket);
        }

        displayPurchasedLottos(tickets);

        return tickets;
    }

    private static int inputSpending() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int purchaseAmount = Integer.parseInt(input);

            validatePuchaseAmount(purchaseAmount);
            return purchaseAmount / 1000;

        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력해 주세요.");

            return inputSpending();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return inputSpending();
        }
    }

    private static void validatePuchaseAmount(int puchaseAmount) {

        if (puchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요");
        }

        if (puchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다");
        }
    }

    private static void displayPurchasedLottos(LottoTickets tickets) {
        System.out.println(tickets.getTickets().size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets.getTickets()) {
            System.out.println(ticket.getNumbers());
        }
    }


}
