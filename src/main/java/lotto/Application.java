package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        try {
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            int ticketCount = purchaseAmount / 1000;
            System.out.println(ticketCount + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(LottoMachine.drawNumbers()));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        



    }
}


public class Application {
    public static void main(String[] args) {

        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(LottoMachine.drawNumbers()));
            System.out.println(tickets.get(i).getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        LottoResult result = new LottoResult();
        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains).count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            result.addResult(LottoRank.valueOf(matchCount, bonusMatch));
        }

        printResult(result, purchaseAmount);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    private static void printResult(LottoResult result, int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;
            System.out.println(rank.name() + " - " + result.getResult().getOrDefault(rank, 0) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateProfitRate(purchaseAmount));
    }
}
