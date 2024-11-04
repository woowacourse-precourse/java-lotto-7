package lotto.domain;

import static lotto.utils.Constants.ENTER;
import static lotto.utils.Reward.FIFTH;
import static lotto.utils.Reward.FIRST;
import static lotto.utils.Reward.FOURTH;
import static lotto.utils.Reward.SECOND;
import static lotto.utils.Reward.THIRD;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import lotto.dto.WinnerStatusDto;
import lotto.utils.DtoMapper;

public class WinnerStatus {

    public static final String COUNT_INDICATOR = "개";

    private final Map<Integer, Integer> rewardMap;
    private final Map<Integer, String> rewardMessage;

    protected WinnerStatus(LottoTickets lottoTickets, WinnerLotto winnerLotto) {
        winnerLotto.validBonusNumber();

        this.rewardMap = initializeRewardMap();
        calculateAllReward(lottoTickets, winnerLotto);

        this.rewardMessage = initMessage();
    }

    public static WinnerStatus create(LottoTickets lottoTickets, WinnerLotto winnerLotto) {

        return new WinnerStatus(lottoTickets, winnerLotto);
    }

    public WinnerStatusDto toDto() {
        return DtoMapper.toWinnerStatusDto(createMessage());
    }

    protected BigDecimal sum() {
        return rewardMap.entrySet()
                .stream()
                .map(entry -> calculate(entry.getKey(), entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void calculateAllReward(LottoTickets lottoTickets, WinnerLotto winnerLotto) {
        lottoTickets.forEach(lotto -> {
            int rewardPrize = winnerLotto.countWinnerMatch(lotto).getPrize();
            this.rewardMap.computeIfPresent(rewardPrize, (key, value) -> value + 1);
        });
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
            String explainReward = explainReward(key);

            joiner.add(explainReward + value + COUNT_INDICATOR);
        }

        return joiner.toString();
    }

    private String explainReward(int reward) {
        return rewardMessage.get(reward);
    }

    private Map<Integer, String> initMessage() {
        Map<Integer, String> message = new TreeMap<>();

        message.put(FIFTH.getPrize(), FIFTH.getDescription());
        message.put(FOURTH.getPrize(), FOURTH.getDescription());
        message.put(THIRD.getPrize(), THIRD.getDescription());
        message.put(SECOND.getPrize(), SECOND.getDescription());
        message.put(FIRST.getPrize(), FIRST.getDescription());

        return message;
    }

    private Map<Integer, Integer> initializeRewardMap() {
        List<Integer> reward = List.of(
                FIRST.getPrize(),
                SECOND.getPrize(),
                THIRD.getPrize(),
                FOURTH.getPrize(),
                FIFTH.getPrize());
        Map<Integer, Integer> rewardMap = new TreeMap<>();

        for (Integer amount : reward) {
            rewardMap.put(amount, 0);
        }

        return rewardMap;
    }
}
