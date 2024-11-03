// package lotto.model;

package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LottoGame {
    private List<Lotto> purchasedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public LottoGame() {
        this.purchasedLottos = new ArrayList<>();
    }

    public int calculateLottoCount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount / LOTTO_PRICE;
    }

    public void purchaseLottos(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(random.ints(1, 46)
                    .distinct()
                    .limit(LOTTO_NUMBERS_COUNT)
                    .sorted()
                    .boxed()
                    .toList());
            purchasedLottos.add(new Lotto(numbers));
        }
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != LOTTO_NUMBERS_COUNT || bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public Map<String, Integer> calculateResults() {
        Map<String, Integer> results = new HashMap<>();

        // 초기 설정: 결과 맵에 각 당첨 조건을 기본값 0으로 초기화
        results.put("3개 일치 (5,000원)", 0);
        results.put("4개 일치 (50,000원)", 0);
        results.put("5개 일치 (1,500,000원)", 0);
        results.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        results.put("6개 일치 (2,000,000,000원)", 0);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            // switch 문: 당첨 개수를 조건에 따라 업데이트
            switch (matchCount) {
                case 3 -> results.merge("3개 일치 (5,000원)", 1, Integer::sum);
                case 4 -> results.merge("4개 일치 (50,000원)", 1, Integer::sum);
                case 5 -> {
                    if (bonusMatch) {
                        results.merge("5개 일치, 보너스 볼 일치 (30,000,000원)", 1, Integer::sum);
                    } else {
                        results.merge("5개 일치 (1,500,000원)", 1, Integer::sum);
                    }
                }
                case 6 -> results.merge("6개 일치 (2,000,000,000원)", 1, Integer::sum);
            }

        }
        return results;
    }

    public double calculateProfitRate(int totalSpent, Map<String, Integer> results) {
        int totalEarnings = 0;

        // 각 당첨 조건에 따른 당첨금과 결과를 이용해 총 당첨금 계산
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();

            // 당첨금 추출
            int prizeMoney;
            switch (key) {
                case "3개 일치 (5,000원)" -> prizeMoney = 5000;
                case "4개 일치 (50,000원)" -> prizeMoney = 50000;
                case "5개 일치 (1,500,000원)" -> prizeMoney = 1500000;
                case "5개 일치, 보너스 볼 일치 (30,000,000원)" -> prizeMoney = 30000000;
                case "6개 일치 (2,000,000,000원)" -> prizeMoney = 2000000000;
                default -> prizeMoney = 0; // 예상치 못한 경우
            }

            // 총 수익 계산
            totalEarnings += prizeMoney * count;
        }

        // 수익률 계산
        double profitRate = (double) totalEarnings / totalSpent * 100;

        // 소수점 둘째 자리에서 반올림
        return Math.round(profitRate * 100.0) / 100.0;
    }

}
