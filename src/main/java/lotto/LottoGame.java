package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGame {
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    public LottoGame(long purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        for (long i = 0; i < purchaseAmount; i++) {
            Lotto lotto = new Lotto(generateRandomLottoNumbers());
            purchasedLottos.add(lotto);
            System.out.println(lotto.toString());
        }
    }

    public void setWinningLotto (List<Integer> winningNumbers){
        this.winningLotto = new Lotto(winningNumbers);
    }

    // 보너스 번호 설정
    public void setBonusNumber(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        this.bonusNumber = bonusNumber;
    }


    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public void calculateResults() {
        Map<Rank, Integer> results = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> results.put(rank, 0)); // 초기화

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, matchBonus); // matchCount와 matchBonus를 기반으로 Rank 판별
            results.put(rank, results.get(rank) + 1); // 해당 Rank의 개수 증가
        }

        printResults(results);
        calculateYield(results);
    }

    private void printResults(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(Rank.FIRST) + "개");
    }

    private void calculateYield(Map<Rank, Integer> results) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(e -> e.getKey().getPrize() * e.getValue()) // prize와 당첨 개수를 곱하여 합산
                .sum();
        int purchaseCost = purchasedLottos.size() * 1000;
        double yield = ((double) totalPrize / purchaseCost) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}