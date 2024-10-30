package lotto.view;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoRank.BonusCondition;

public class RankMessageGenerator {

    private static final String FULL_MESSAGE_FORMAT = "%s (%s) - %s";
    private static final String NEEDED_COUNT_FORMAT = "%d개 일치";
    private static final String BONUS_CONDITION_DELIMITER = ", ";
    private static final String BONUS_CONDITION = "보너스 볼 일치";
    private static final String REWARD_FORMAT = "%,d원";
    private static final int DEFAULT_COUNT = 0;
    private static final String MATCHING_NUMBER_COUNT_FORMAT = "%d개";

    public String getMessage(LottoRank lottoRank, Map<LottoRank, Integer> ranks) {
        String matchConditionMessage = getMatchConditionMessage(lottoRank);
        String rewardMessage = getRewardMessage(lottoRank);
        String matchingCountMessage = getMatchingNumberCountMessage(ranks, lottoRank);

        return String.format(FULL_MESSAGE_FORMAT, matchConditionMessage, rewardMessage, matchingCountMessage);
    }

    private String getMatchConditionMessage(LottoRank lottoRank) {
        int matchingCount = lottoRank.getNeededCount();
        BonusCondition bonusCondition = lottoRank.getBonusCondition();

        String matchCountMessage = getNeededCountMessage(matchingCount);

        if (bonusCondition == BonusCondition.MATCHED) {
            return String.join(BONUS_CONDITION_DELIMITER, matchCountMessage, BONUS_CONDITION);
        }

        return matchCountMessage;
    }

    private String getNeededCountMessage(int matchingCount) {
        return String.format(NEEDED_COUNT_FORMAT, matchingCount);
    }

    private String getRewardMessage(LottoRank lottoRank) {
        int rewardAmount = lottoRank.getRewardAmount();
        return String.format(REWARD_FORMAT, rewardAmount);
    }

    private String getMatchingNumberCountMessage(Map<LottoRank, Integer> ranks, LottoRank lottoRank) {
        int matchCount = ranks.getOrDefault(lottoRank, DEFAULT_COUNT);
        return String.format(MATCHING_NUMBER_COUNT_FORMAT, matchCount);
    }

}
