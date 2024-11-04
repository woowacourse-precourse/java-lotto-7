package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class LottoView {
    public int inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        List<Integer> winningNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(st.nextToken()));
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void printPurchasedTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printResults(List<Integer> results, double profitRate) {
        System.out.println("\n당첨 통계\n---");
        String[] prizeDescriptions = {
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        };

        for (int i = 0; i < results.size(); i++) {
            System.out.println(prizeDescriptions[i] + " - " + results.get(i) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
