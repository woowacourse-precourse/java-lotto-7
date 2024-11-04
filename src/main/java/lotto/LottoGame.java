package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> tickets = generateTickets(purchaseAmount / LOTTO_PRICE);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());
                if (amount < 0 || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 구입 금액입니다. 1000원 단위로 입력해 주세요.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return tickets;
    }
}
