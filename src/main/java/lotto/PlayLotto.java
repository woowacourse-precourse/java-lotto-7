package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    private final BuyTicket buyTicket;
    private final WinningLotto winningLotto;
    private final int purchaseAmount;

    public PlayLotto() {
        this.purchaseAmount = inputPurchaseAmount();

        this.buyTicket = new BuyTicket(purchaseAmount);
        System.out.println(buyTicket.getTickets().size() + "개를 구매했습니다.");

        for (Lotto lotto : buyTicket.getTickets()) {
            System.out.println(lotto);
        }

        this.winningLotto = inputWinningNumbers();
        printResult();
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        // 숫자 입력 검증
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
                input = Console.readLine(); // 다시 입력 받기
            }
        }
    }

    private WinningLotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbersInput = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumbersInput) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void printResult() {
        int[] prizeCount = new int[6];
        for (Lotto lotto : buyTicket.getTickets()) {
            int prize = winningLotto.calculatePrize(lotto);
            if (prize > 0) {
                prizeCount[prize]++;
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeCount[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[1] + "개");

        int totalPrize = calculateTotalPrize(prizeCount);
        double returnRate = calculateReturnRate(totalPrize);

        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }

    private int calculateTotalPrize(int[] prizeCount) {
        int totalPrize = 0;
        totalPrize += prizeCount[5] * 5000;          // 3개 일치
        totalPrize += prizeCount[4] * 50000;         // 4개 일치
        totalPrize += prizeCount[3] * 1500000;       // 5개 일치
        totalPrize += prizeCount[2] * 30000000;      // 5개 일치, 보너스 볼 일치
        totalPrize += prizeCount[1] * 2000000000;    // 6개 일치
        return totalPrize;
    }

    private double calculateReturnRate(int totalPrize) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}
