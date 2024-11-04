package domain;

import message.Prize;

public class Ranking {

    private static final int WINNING_MIN_COUNT = 3;

    public static Prize valueOf(int count, boolean isBonus) {
        if(count < WINNING_MIN_COUNT) {
            return Prize.MISS;
        }
        if(matchCount(count) && isBonus) {
            return Prize.FIVE_BONUS_MATCHES;
        }
        for(Prize prize : Prize.values()) {
            if(!prize.equals(Prize.FIVE_BONUS_MATCHES) && matchCount(count)) {
                return prize;
            }
        }
        return Prize.MISS;
    }

    private static boolean matchCount(int count) {

        return Prize.FIVE_BONUS_MATCHES.getMatches() == count;
    }
}
