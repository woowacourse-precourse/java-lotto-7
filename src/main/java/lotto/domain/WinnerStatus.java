package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;
import lotto.dto.WinnerStatusDto;
import lotto.utils.DtoMapper;

public class WinnerStatus {

    private final Map<Integer, Integer> rewardMap;
    private final StatusMessage statusMessage;

    public WinnerStatus(WinnerCountList winnerCountList) {
        this.rewardMap = winnerCountList.calculateAllReward();
        this.statusMessage = new StatusMessage();
    }

    public static WinnerStatus create(WinnerCountList winnerCountList) {
        return new WinnerStatus(winnerCountList);
    }

    public WinnerStatusDto toDto() {
        return DtoMapper.toWinnerStatusDto(this, createMessage());
    }

    private String createMessage() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for (Map.Entry<Integer, Integer> entry : rewardMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            String explainReward = statusMessage.explainReward(key);

            joiner.add(explainReward + value + "개");
        }

        return joiner.toString();
    }

    protected BigDecimal sum() {
        return rewardMap.entrySet().stream()
                .map(entry -> calculate(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculate(int key, int value) {
        BigDecimal bigKey = new BigDecimal(String.valueOf(key));
        BigDecimal bigValue = new BigDecimal(String.valueOf(value));

        return bigKey.multiply(bigValue);
    }


}
