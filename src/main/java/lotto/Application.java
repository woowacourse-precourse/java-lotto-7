package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputAmount();
        int ticketCount = calculateTicketCount(purchaseAmount);
        System.out.println(ticketCount + "개를 구매했습니다.");
        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);
        printLottoTickets(lottoTickets);
        List<Integer> winningNumbers = inputWinningNumbers();
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

    private static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }





}
