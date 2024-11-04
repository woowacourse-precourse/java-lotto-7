package lotto.model.enums;

public enum WinningType {
    NOTHING(0L), THREE(5000L), FOUR(50000L), FIVE(1500000L), FIVE_BONUS(30000000L), SIX(2000000000L);

    private Long prize;

    WinningType(Long prize) {
        this.prize = prize;
    }

    public static WinningType getWinningType(Integer matchCount, boolean matchBonus){
        if(matchCount == 3){
            return THREE;
        }
        if(matchCount == 4){
            return FOUR;
        }
        if(matchCount == 5){
            return FIVE;
        }
        if(matchCount == 5 && matchBonus){
            return FIVE_BONUS;
        }
        if(matchCount == 6){
            return SIX;
        }
        return NOTHING;
    }
}
