package lotto.domain;

import static lotto.utils.Constants.ENTER;

import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;
import lotto.dto.WinnerStatusDto;
import lotto.utils.DtoMapper;

public class WinnerStatus {

    public static final String COUNT_INDICATOR = "개";

    private final Map<Integer, Integer> rewardMap;
    private final RewardMessage rewardMessage;

    public WinnerStatus(WinnerCountList winnerCountList) {
        this.rewardMap = winnerCountList.calculateAllReward();
        this.rewardMessage = new RewardMessage();
    }

    public static WinnerStatus create(WinnerCountList winnerCountList) {
        return new WinnerStatus(winnerCountList);
    }

    public WinnerStatusDto toDto() {
        return DtoMapper.toWinnerStatusDto(createMessage());
    }

    protected BigDecimal sum() {
        return rewardMap.entrySet().stream().map(entry -> calculate(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculate(int key, int value) {
        BigDecimal bigKey = new BigDecimal(String.valueOf(key));
        BigDecimal bigValue = new BigDecimal(String.valueOf(value));

        return bigKey.multiply(bigValue);
    }

    private String createMessage() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Map.Entry<Integer, Integer> entry : rewardMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            String explainReward = rewardMessage.explainReward(key);

            joiner.add(explainReward + value + COUNT_INDICATOR);
        }

        return joiner.toString();
    }

}
