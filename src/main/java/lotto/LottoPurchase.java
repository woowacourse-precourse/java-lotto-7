package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Integer::compareTo);
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
