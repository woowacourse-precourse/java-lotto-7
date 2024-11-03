package lotto.view.io.message;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRank.BonusCondition;

public class RankMessageGenerator {

    private static final String FULL_MESSAGE_FORMAT = "%s (%s) - %s";
    private static final String NEEDED_COUNT_FORMAT = "%d개 일치";
    private static final String BONUS_CONDITION_DELIMITER = ", ";
    private static final String BONUS_CONDITION = "보너스 볼 일치";
    private static final String REWARD_FORMAT = "%,d원";
    private static final int DEFAULT_COUNT = 0;
    private static final String NUMBER_COUNT_FORMAT = "%d개";

    public String getMessage(LottoRank lottoRank, Integer sameNumberCount) {
        String matchConditionMessage = getMatchConditionMessage(lottoRank);
        String rewardMessage = getRewardMessage(lottoRank);
        String matchingCountMessage = getSameNumberCountMessage(sameNumberCount);

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

    private String getNeededCountMessage(int neededCount) {
        return String.format(NEEDED_COUNT_FORMAT, neededCount);
    }

    private String getRewardMessage(LottoRank lottoRank) {
        int rewardAmount = lottoRank.getRewardAmount();
        return String.format(REWARD_FORMAT, rewardAmount);
    }

    private String getSameNumberCountMessage(Integer sameNumberCount) {
        if (sameNumberCount == null) {
            sameNumberCount = DEFAULT_COUNT;
        }
        return String.format(NUMBER_COUNT_FORMAT, sameNumberCount);
    }

}
