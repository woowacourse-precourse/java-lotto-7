package lotto.domain.gameManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.controller.Policy;
import lotto.controller.TierPolicy;
import lotto.controller.dto.LotteryStatisticsResultDTO;
import lotto.domain.lottery.Lotteries;
import lotto.domain.lottery.Lottery;
import lotto.domain.lottery.Lotto;
import lotto.domain.statistics.LotteryStatisticsHistory;
import lotto.domain.statistics.LottoDrawStatistics;
import lotto.domain.statistics.Statistics;
import lotto.domain.tier.Tier;
import lotto.domain.vo.WinningNumberMatchCountVO;

public class LottoGameManager implements GameManager {
    private final TierPolicy tierPolicy;

    private LottoGameManager(TierPolicy tierPolicy) {
        this.tierPolicy = tierPolicy;
    }

    public static LottoGameManager ofInstance(TierPolicy tierPolicy) {
        return new LottoGameManager(tierPolicy);
    }

    @Override
    public Lotteries generateLottery(Policy policy, int inputAmount) {
        List<Lottery> lotteries = new ArrayList<>();
        int calculateBuyCount = calculateBuyCount(policy.getAmountPolicy(), inputAmount);
        for (int i = 0; i < calculateBuyCount; i++) {
            List<Integer> pickLottoNumber = Randoms.pickUniqueNumbersInRange(
                    policy.getMinNumberLimit(), policy.getMaxNumberLimit(), policy.getWinningNumberCount());
            ArrayList<Integer> pickLottoNumberList = new ArrayList<>(pickLottoNumber);
            Collections.sort(pickLottoNumberList);
            Lotto lotto = new Lotto(pickLottoNumberList);
            lotteries.add(lotto);
        }
        return Lotteries.newInstance(lotteries);
    }

    @Override
    public int calculateBuyCount(int lotteryAmount, int inputAmount) {
        return inputAmount / lotteryAmount;
    }

    @Override
    public List<Statistics> initStatistics() {
        List<Tier> tiers = tierPolicy.initTiers();
        return tiers.stream().map(LottoDrawStatistics::initStatistics).toList();
    }

    @Override
    public LotteryStatisticsResultDTO checkWinningLottery(int inputAmount, Lotteries boughtLotteries,
                                                          List<Integer> winningNumbers,
                                                          int bonusNumber,
                                                          LotteryStatisticsHistory lotteryStatisticsHistory) {
        List<WinningNumberMatchCountVO> winningNumberMatchCounts = boughtLotteries.winningNumberMatchCount(
                winningNumbers);
        BigInteger totalWinningAmount = BigInteger.ZERO;
        lotteryStatisticsHistory.addLotteryStatisticsHistory(0L, initStatistics());
        //일치 번호 리스트 돌면서
        for (int i = 0; i < winningNumberMatchCounts.size(); i++) {
            List<Statistics> statistics = lotteryStatisticsHistory.getStatistics(0L);
            WinningNumberMatchCountVO vo = winningNumberMatchCounts.get(i);
            //복권번호에서 당첨번호가 몇개 포함되어있는지 미리 찾아놓고
            Integer matchedNumberCount = vo.lottery().countMatchingWinningNumbers(winningNumbers);
            // ? 로직수정...
            List<Statistics> winningLotto = findWinningLotto(bonusNumber, statistics, vo, matchedNumberCount);
            lotteryStatisticsHistory.addLotteryStatisticsHistory(i + 1L, winningLotto);
        }
        List<Statistics> statistics = lotteryStatisticsHistory.getStatistics(lotteryStatisticsHistory.getSize() - 1);
        totalWinningAmount = calculateTotalWinningAmount(statistics, totalWinningAmount);
        Double returnRate = calculateReturnRate(inputAmount, totalWinningAmount);
        return new LotteryStatisticsResultDTO(statistics, returnRate);
    }

    private void foo(int matchCount, boolean bonusNumberMatches) {
        if (matchCount == 5 && bonusNumberMatches){

        }
    }


    private Double calculateReturnRate(int inputAmount, BigInteger totalWinningAmount) {
        BigDecimal totalWinningAmountBigDecimal = new BigDecimal(totalWinningAmount);
        double returnRate = totalWinningAmountBigDecimal.divide(BigDecimal.valueOf(inputAmount), 3,
                BigDecimal.ROUND_HALF_UP).doubleValue();
        return returnRate * 100;
    }

    private BigInteger calculateTotalWinningAmount(List<Statistics> statistics, BigInteger totalWinningAmount) {

        for (Statistics statisticsData : statistics) {
            totalWinningAmount = totalWinningAmount.add(statisticsData.calculateWinningAmount());
        }
        return totalWinningAmount;
    }

    private List<Statistics> findWinningLotto(int bonusNumber, List<Statistics> statistics,
                                              WinningNumberMatchCountVO vo,
                                              Integer matchedNumberCount) {
        // statisticsList 가 5개가 됨 -> 1,2,3,4,5이렇게 들어있어.
        List<Statistics> statisticsList = new ArrayList<>();
        for (Statistics statisticsData : statistics) {
            //보너스 번호가 필요한지 확인
            statisticsList.add(checkNeedBonusNumber(bonusNumber, vo.lottery(), matchedNumberCount, statisticsData)
            );
        }
        return statisticsList;
    }

    private Statistics checkNeedBonusNumber(int bonusNumber, Lottery lottery, Integer matchedNumberCount,
                                            Statistics statistics) {
        if (matchedNumberCount == 5 && lottery.contains(bonusNumber)) {

        }
        //보너스 번호가 필요하면
        if (statistics.getTier().getNeedsBonusNumberMatch()) {
            // lottery 번호에 보너스번호가 포함되어있고, 필요한 당첨번호와 당첨된번호의 개수가 같은지 확인
            return checkBonusMatch(bonusNumber, lottery, matchedNumberCount, statistics);
        }

        if (!statistics.getTier().getNeedsBonusNumberMatch()) {
            return checkMatchedNumberCount(matchedNumberCount, statistics);
        }
        return statistics;
    }

    private Statistics checkBonusMatch(int bonusNumber, Lottery lottery, Integer matchedNumberCount,
                                       Statistics statistics) {
        // lottery 번호에 보너스번호가 포함어있고, 필요한 당첨번호와 당첨된번호의 개수가 같으면
        if (statistics.getTier().getRequiredMatchCount().equals(matchedNumberCount)
                && lottery.contains(bonusNumber)) {
            //당첨 개수 증가.
            statistics.updateWinningLottoCount();
        }
        return statistics;
    }

    private Statistics checkMatchedNumberCount(Integer matchedNumberCount, Statistics statistics) {
        if (statistics.getTier().getRequiredMatchCount().equals(matchedNumberCount)) {
            statistics.updateWinningLottoCount();
        }
        return statistics;
    }

}
