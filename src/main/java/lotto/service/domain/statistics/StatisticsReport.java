package lotto.service.domain.statistics;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.service.domain.lotto.LottoBuyer;
import lotto.service.domain.lotto.LottoReward;
import lotto.service.domain.money.Money;

public class StatisticsReport { // 책임: 통계를 넘겨 준다. 이걸로 출력에 관한 클래스가 출력한다.
    private List<LottoReward> lottoRewardInfo;
    private double profitRate;
    private static final double PERCENT = 100;
    private Map<LottoReward, Integer> countLottoReward;
    private LottoBuyer lottoBuyer;

    public StatisticsReport(List<LottoReward> lottoRewardInfo, LottoBuyer lottoBuyer) {
        countLottoReward = new EnumMap<>(LottoReward.class);
        mapInit();
        this.lottoBuyer = lottoBuyer;
        this.lottoRewardInfo = lottoRewardInfo;
        calculateProfitRate();
    }

    private void mapInit() {
        Arrays.stream(LottoReward.values())
                .forEach(lottoReward -> countLottoReward.put(lottoReward, 0));
    }

    private void calculateProfitRate() {
        double seedMoney = lottoBuyer.getBudget().getBudget();

        lottoRewardInfo.forEach
                (winInfoKey -> countLottoReward.put(winInfoKey, countLottoReward.get(winInfoKey) + 1));

        double sumReward = countLottoReward.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        this.profitRate = (double) (sumReward * PERCENT) / seedMoney;
    }

    public List<LottoReward> getLottoRewardInfo() {
        return lottoRewardInfo;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<LottoReward, Integer> getCountLottoReward() {
        return countLottoReward;
    }

    public LottoBuyer getLottoBuyer() {
        return lottoBuyer;
    }
}
