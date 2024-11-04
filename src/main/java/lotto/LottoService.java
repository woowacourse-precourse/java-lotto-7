package lotto;

import camp.nextstep.edu.missionutils.Console;
public class LottoService {
    private final Selling selling = new Selling();
    private final Benefit benefit = new Benefit();

    public void run() {
        try {
            int amount = getPurchaseAmount();
            Lotto[] userLottos = selling.purchaseLottos(amount);

            int[] winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            Winning winning = new Winning(winningNumbers, bonusNumber);

            int[] ranks = calculateResults(userLottos, winning);
            displayResults(ranks);
            displayBenefit(amount, ranks);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int[] calculateResults(Lotto[] userLottos, Winning winning) {
        int[] ranks = new int[6];
        for (Lotto lotto : userLottos) {
            int rank = winning.checkLotto(lotto);
            if (rank > 0) ranks[rank]++;
        }
        return ranks;
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(("[ERROR] 금액은 1,000원 단위여야 합니다."));
        }
        return amount;
    }

    private int[] getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] winningInput = Console.readLine().split(",");
        int[] winningNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = Integer.parseInt(winningInput[i].trim());
            if(winningNumbers[i]<1||winningNumbers[i]>45){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자입니다.");
            }
        }
        return winningNumbers;
    }

    private int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(bonusNumber<1||bonusNumber>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자입니다.");
        }
        return bonusNumber;
    }

    private void displayBenefit(int amount, int[] ranks) {
        double yield = benefit.calculateBenefit(amount, ranks);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private void displayResults(int[] ranks) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", ranks[5]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", ranks[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", ranks[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", ranks[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", ranks[1]);
    }

}
