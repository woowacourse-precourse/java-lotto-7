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
                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
                input = Console.readLine(); // 다시 입력 받기
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = Console.readLine(); // 다시 입력 받기
            }
        }
    }

    private WinningLotto inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] winningNumbersInput = Console.readLine().split(",");

            if (winningNumbersInput.length != 6) {
                System.out.println("[ERROR] 입력된 당첨 번호는 6개여야 합니다.");
                continue; // 다시 입력 받기
            }

            winningNumbers.clear(); // 이전 입력 초기화
            boolean isValid = true;
            for (String number : winningNumbersInput) {
                int num = Integer.parseInt(number.trim());
                if (num < 1 || num > 45) {
                    System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    isValid = false;
                    break; // 유효하지 않은 번호가 있으면 반복 종료
                }
                winningNumbers.add(num);
            }

            if (!isValid) {
                continue; // 유효하지 않은 경우 다시 입력 받기
            }

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber;
            while (true) {
                bonusNumber = Integer.parseInt(Console.readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                } else {
                    break; // 유효한 보너스 번호면 반복 종료
                }
            }

            return new WinningLotto(winningNumbers, bonusNumber);
        }
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
