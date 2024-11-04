package lotto;

import java.util.List;

public class LottoResult {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void display() {
        int[] prizes = new int[5];
        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            int prize = calculatePrize(matchCount, bonusMatch);
            totalPrize += prize;
            if (prize > 0) prizes[getRank(matchCount, bonusMatch) - 3]++;
        }

        displayResults(prizes, totalPrize);
    }

    private int calculatePrize(int matchCount, boolean bonusMatch) {
        return switch (matchCount) {
            case 6 -> 2_000_000_000;
            case 5 -> bonusMatch ? 30_000_000 : 1_500_000;
            case 4 -> 50_000;
            case 3 -> 5_000;
            default -> 0;
        };
    }

    private int getRank(int matchCount, boolean bonusMatch) {
        return switch (matchCount) {
            case 6 -> 1;
            case 5 -> bonusMatch ? 2 : 3;
            case 4 -> 4;
            case 3 -> 5;
            default -> -1;
        };
    }

    private void displayResults(int[] prizes, int totalPrize) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", prizes[0]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", prizes[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", prizes[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", prizes[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", prizes[4]);

        double profit = ((double) totalPrize / (lottos.size() * 1000)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(profit * 10) / 10.0);
    }
}
