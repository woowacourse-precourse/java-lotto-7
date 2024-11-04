package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static final int PRICE_PER_LOTTO = 1000;

    public List<Lotto> purchaseLotto() {
        int amount = inputAmount();
        return generateTickets(amount / PRICE_PER_LOTTO);
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                return parseAndValidateAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int parseAndValidateAmount(String input) {
        int amount = parseAmount(input);
        validateAmount(amount);
        return amount;
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0보다 커야 합니다.");
        }
        if (amount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    public List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(createLotto());
        }
        printTickets(tickets);
        return tickets;
    }

    private void printTickets(List<Lotto> tickets) {
        System.out.println("\n" + tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    protected Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
