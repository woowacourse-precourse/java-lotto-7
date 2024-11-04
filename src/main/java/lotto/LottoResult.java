package lotto;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final List<Lotto> userLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<String, Integer> resultCountMap = new HashMap<>();
    private static final int[] PRIZE = {5000, 50000, 1500000, 30000000, 2000000000};

    private static final String[] RESULT_MESSAGES = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    };

    public LottoResult(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        this.userLottos = userLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        initializeResultMap();
        processResults();
    }

    // 초기값을 모두 0으로 설정
    private void initializeResultMap() {
        for (String message : RESULT_MESSAGES) {
            resultCountMap.put(message, 0);
        }
    }

    // 각 로또에 대해 updateResultCount() 호출
    private void processResults() {
        userLottos.forEach(this::updateResultCount);
    }

    // 일치 개수에 따라 해당 등수 카운트 증가
    private void updateResultCount(Lotto userLotto) {
        int matchCount = getMatchCount(userLotto);
        if (matchCount == 6) { increaseResultCount(4); return; }
        if (matchCount == 5 && containsBonus(userLotto)) { increaseResultCount(3); return; }
        if (matchCount == 5) { increaseResultCount(2); return; }
        if (matchCount == 4) { increaseResultCount(1); return; }
        if (matchCount == 3) { increaseResultCount(0); }
    }

    // 지정된 인덱스에 해당하는 메시지의 카운트를 증가
    private void increaseResultCount(int index) {
        String message = RESULT_MESSAGES[index];
        resultCountMap.put(message, resultCountMap.get(message) + 1);
    }

    // 보너스 번호 일치 여부
    private boolean containsBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    // 맞춘 번호 개수 반환
    private int getMatchCount(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    // 결과 출력 (당첨 현황, 수익률)
    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (String message : RESULT_MESSAGES) {
            System.out.println(message + resultCountMap.get(message) + "개");
        }
        printYield();
    }

    // 수익률 출력
    private void printYield() {
        double yield = calculateYield();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    // 수익률 계산
    private double calculateYield() {
        int totalPrize = calculateTotalPrize();
        int totalPurchase = userLottos.size() * 1000;
        return ((double) totalPrize / totalPurchase) * 100;
    }

    // 총 상금 합산
    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (int i = 0; i < RESULT_MESSAGES.length; i++) {
            totalPrize += resultCountMap.get(RESULT_MESSAGES[i]) * PRIZE[i];
        }

        return totalPrize;
    }
}
