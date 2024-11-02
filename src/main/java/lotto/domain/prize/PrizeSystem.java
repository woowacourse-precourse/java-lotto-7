package lotto.domain.prize;

import lotto.domain.lotto.Lotto;

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
    }

    /**
     * 발행한 로또들의 당첨 내역 확인
     */
    public void checkPrizeResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers);
            updatePrizeCount(lottoNumbers, matchCount);
        }
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
            prizeCount.addOneFirstPrizeCount();
        }
        if (matchCount == MATCH_SECOND_THIRD) {
            bonusCase(lottoNumbers);
        }
        if (matchCount == MATCH_FOURTH) {
            prizeCount.addOneFourthPrizeCount();
        }
        if (matchCount == MATCH_FIFTH) {
            prizeCount.addOneFifthPrizeCount();
        }
    }

    /**
     * 보너스 번호를 비교해야 하는 경우 (2,3등을 가려야 하는 경우)
     */
    public void bonusCase(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            prizeCount.addOneSecondPrizeCount();
            return;
        }
        prizeCount.addOneThirdPrizeCount();
    }

    /**
     * 총 당첨 금액 계산
     */
    public int getPrizeMoney() {
        int prizeMoney = PrizeMoney.PRIZE_FIRST.getPrizeMoney() * prizeCount.getFirstPrizeCount() +
                PrizeMoney.PRIZE_SECOND.getPrizeMoney() * prizeCount.getSecondPrizeCount() +
                PrizeMoney.PRIZE_THIRD.getPrizeMoney() * prizeCount.getThirdPrizeCount() +
                PrizeMoney.PRIZE_FOURTH.getPrizeMoney() * prizeCount.getFourthPrizeCount() +
                PrizeMoney.PRIZE_FIFTH.getPrizeMoney() * prizeCount.getFifthPrizeCount();
        return prizeMoney;
    }

    /**
     * 수익률 계산
     */
    public double getProfit(int purchaseMoney) {
        int prizeMoney = getPrizeMoney();
        double profit = (double) prizeMoney / purchaseMoney * 100;
        return profit;
    }

    /**
     * 당첨 통계 변수 getter
     */
    public PrizeCount getPrizeCount() {
        return prizeCount;
    }
}
