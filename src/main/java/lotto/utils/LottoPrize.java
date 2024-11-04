package lotto.utils;

public enum LottoPrize {
    MATCH_THREE("3개 일치", 5000) {
        @Override
        public boolean isMatchCondition(int matchCount, boolean hasBonus) {
            return (matchCount == 3 && !hasBonus) || (matchCount == 2 && hasBonus);
        }
    },
    MATCH_FOUR("4개 일치", 50000) {
        @Override
        public boolean isMatchCondition(int matchCount, boolean hasBonus) {
            return (matchCount == 4 && !hasBonus) || (matchCount == 3 && hasBonus);
        }
    },
    MATCH_FIVE("5개 일치", 1500000) {
        @Override
        public boolean isMatchCondition(int matchCount, boolean hasBonus) {
            return (matchCount == 5 && !hasBonus) || (matchCount == 4 && hasBonus);
        }
    },
    MATCH_FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치", 30000000) {
        @Override
        public boolean isMatchCondition(int matchCount, boolean hasBonus) {
            return matchCount == 5 && hasBonus;
        }
    },
    MATCH_SIX("6개 일치", 2000000000) {
        @Override
        public boolean isMatchCondition(int matchCount, boolean hasBonus) {
            return matchCount == 6 && !hasBonus;//로또의 숫자 갯수는 6개니까.
        }
    };

    final String prizeMessage;
    final int reward;

    LottoPrize(String prizeMessage, int reward) {
        this.prizeMessage = prizeMessage + String.format(" (%,d원) - ", reward) + "%d개";
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }

    public String getPrizeMessage() {
        return this.prizeMessage;
    }

    public abstract boolean isMatchCondition(int matchCount, boolean hasBonus);
}
