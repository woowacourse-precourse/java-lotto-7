package lotto.domain;

import java.util.List;

public class PrizeSystem {

    private static final int MATCH_FIRST = 6;
    private static final int MATCH_SECOND_THIRD = 5;
    private static final int MATCH_FOURTH = 4;
    private static final int MATCH_FIFTH = 3;

    private final List<Integer> prizeNumbers;
    private final int bonusNumber;

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public PrizeSystem(List<Integer> prizeNumbers, int bonusNumber) {
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;

        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
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
    public void calculatePrizeCount(List<Integer> lottoNumbers, int matchCount) {
        if (matchCount == MATCH_FIRST) {
            firstPrizeCount += 1;
        }
        if (matchCount == MATCH_SECOND_THIRD) {
            bonusCase(lottoNumbers);
        }
        if (matchCount == MATCH_FOURTH) {
            fourthPrizeCount += 1;
        }
        if (matchCount == MATCH_FIFTH) {
            fifthPrizeCount += 1;
        }
    }

    /**
     * 보너스 번호를 비교해야 하는 경우 (2,3등을 가려야 하는 경우)
     */
    public void bonusCase(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            secondPrizeCount += 1;
            return;
        }
        thirdPrizeCount += 1;
    }

    /**
     * 총 당첨 금액 계산
     */
    public int getPrizeMoney() {
        int prizeMoney = PrizeMoney.PRIZE_FIRST.getPrizeMoney() * firstPrizeCount +
                PrizeMoney.PRIZE_SECOND.getPrizeMoney() * secondPrizeCount +
                PrizeMoney.PRIZE_THIRD.getPrizeMoney() * thirdPrizeCount +
                PrizeMoney.PRIZE_FOURTH.getPrizeMoney() * fourthPrizeCount +
                PrizeMoney.PRIZE_FIFTH.getPrizeMoney() * fifthPrizeCount;
        return prizeMoney;
    }

    /**
     * 수익률 계산
     */
    public double getProfit(int purchaseMoney, int prizeMoney) {
        double profit = prizeMoney / purchaseMoney * 100;
        return profit;
    }
}
