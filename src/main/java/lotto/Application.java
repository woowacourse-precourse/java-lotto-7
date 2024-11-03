package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        int purchaseAmount = inputAmount();
        // TODO: 프로그램 구현
    }
    private static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (!isNum(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        return amount;
    }

    private static boolean isNum(String str) {
        return str.matches("\\d+");
    }

    private static int calculateTicketCount(int amount){
        return amount / LOTTO_PRICE;
    }
    private static List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            Set<Integer> numbers = new TreeSet<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(new Lotto(new ArrayList<>(numbers)));
        }

        return lottoTickets;
    }



}
