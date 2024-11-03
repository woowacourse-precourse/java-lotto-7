package lotto.domain;

public enum Prize {
    FIRST(6,2_000_000_000, "6개 일치"),
    SECOND(5,30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5,1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    FAIL(0, 0, "낙첨");

    private final int matchCount;
    private final int rewards;
    private final String description;

    Prize(int matchCount, int rewards, String description) {
        this.matchCount = matchCount;
        this.rewards = rewards;
        this.description = description;
    }

    public static Prize winningMatch(int matchCount, boolean bonusMatch) {
        if(SECOND.matchCount == matchCount && bonusMatch)
            return SECOND;

        for(Prize prize : Prize.values()) {
            if(prize.matchCount == matchCount)
                return prize;
        }

        return FAIL;
    }

    public static Prize[] lowToHigh(){
        Prize[] prizes = Prize.values();
        Prize[] reversePrizes = new Prize[prizes.length - 1];

        for(int i = 0; i < reversePrizes.length; i++){
            reversePrizes[i] = prizes[reversePrizes.length - 1 - i];
        }

        return reversePrizes;
    }

    public int getRewards() {
        return rewards;
    }
    
    @Override
    public String toString() {
        return description + " (" + String.format("%,d", rewards) + "원) - ";
    }
}
