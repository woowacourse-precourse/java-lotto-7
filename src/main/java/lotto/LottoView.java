package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class LottoView {
    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % 1000 != 0){
                    throw new IllegalArgumentException();
                }
                return purchaseAmount;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]: 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            }
        }
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
                List<Integer> numbers = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    numbers.add(Integer.parseInt(st.nextToken()));
                }
                return new Lotto(numbers);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]: 로또 번호는 중복되지 않은 6개 숫자입니다.");
            }
        }

    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printPurchasedTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printResults(List<Integer> results, double profitRate) {
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
