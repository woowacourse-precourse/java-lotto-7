package lotto.domain;

import java.util.List;

public class PrizeSystem {

    private static final int MATCH_FIRST = 6;
    private static final int MATCH_SECOND_THIRD = 5;
    private static final int MATCH_FOURTH = 4;
    private static final int MATCH_FIFTH = 3;

    private final List<Integer> prizeNumbers;
    private final int bonusNumber;

    // 당첨 통계 변수 - 당첨 카운팅
    private PrizeCount prizeCount;

    public PrizeSystem(List<Integer> prizeNumbers, int bonusNumber) {
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;

        prizeCount = new PrizeCount();
        prizeCount.firstPrizeCount = 0;
        prizeCount.secondPrizeCount = 0;
        prizeCount.thirdPrizeCount = 0;
        prizeCount.fourthPrizeCount = 0;
        prizeCount.fifthPrizeCount = 0;
    }

    /**
     * 로또 번호 6개 중 당첨 번호와 일치하는 번호 개수 반환
     */
    public int getMatchCount(List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (prizeNumbers.contains(lottoNumber)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    /**
     * 일치하는 번호 개수를 통해 당첨 통계에 업데이트
     */
    public void updatePrizeCount(List<Integer> lottoNumbers, int matchCount) {
        if (matchCount == MATCH_FIRST) {
            prizeCount.firstPrizeCount += 1;
        }
        if (matchCount == MATCH_SECOND_THIRD) {
            bonusCase(lottoNumbers);
        }
        if (matchCount == MATCH_FOURTH) {
            prizeCount.fourthPrizeCount += 1;
        }
        if (matchCount == MATCH_FIFTH) {
            prizeCount.fifthPrizeCount += 1;
        }
    }

    /**
     * 보너스 번호를 비교해야 하는 경우 (2,3등을 가려야 하는 경우)
     */
    public void bonusCase(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            prizeCount.secondPrizeCount += 1;
            return;
        }
        prizeCount.thirdPrizeCount += 1;
    }

    /**
     * 총 당첨 금액 계산
     */
    public int getPrizeMoney() {
        int prizeMoney = PrizeMoney.PRIZE_FIRST.getPrizeMoney() * prizeCount.firstPrizeCount +
                PrizeMoney.PRIZE_SECOND.getPrizeMoney() * prizeCount.secondPrizeCount +
                PrizeMoney.PRIZE_THIRD.getPrizeMoney() * prizeCount.thirdPrizeCount +
                PrizeMoney.PRIZE_FOURTH.getPrizeMoney() * prizeCount.fourthPrizeCount +
                PrizeMoney.PRIZE_FIFTH.getPrizeMoney() * prizeCount.fifthPrizeCount;
        return prizeMoney;
    }

    /**
     * 수익률 계산
     */
    public double getProfit(int purchaseMoney) {
        int prizeMoney = getPrizeMoney();
        double profit = prizeMoney / purchaseMoney * 100;
        return profit;
    }

    /**
     * 당첨 통계 이너 클래스
     */
    class PrizeCount {
        private int firstPrizeCount;
        private int secondPrizeCount;
        private int thirdPrizeCount;
        private int fourthPrizeCount;
        private int fifthPrizeCount;
    }

    /**
     * 당첨 통계 변수 getter
     */
    public PrizeCount getPrizeCount() {
        return prizeCount;
    }
}
