package lotto.model;

import java.text.DecimalFormat;

/** 로또 당첨 등급 별 조건, 상금을 보관한다 */
public enum PrizeGrade {
    THREE_MATCH("3개 일치", 5000, 3, false),
    FOUR_MATCH("4개 일치", 50000, 4, false),
    FIVE_MATCH("5개 일치", 1500000, 5, false),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치", 30000000, 5, true),
    SIX_MATCH("6개 일치",2000000000, 6, false);
    
    private static final DecimalFormat COMMA_IN_THREE = new DecimalFormat("###,###");
    
    private final String condition;
    
    private final int money;
    
    private final int matchCount;
    
    private final boolean matchBonus;
    
    PrizeGrade(String condition, int money, int matchCount, boolean matchBonus) {
        this.condition = condition;
        this.money = money;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }
    
    
    public static PrizeGrade get(int matchCountInput, boolean isBonusMatch) {
        PrizeGrade gradeToReturn = null;
        for (PrizeGrade grade : PrizeGrade.values()) {
            if (matchCountInput == grade.matchCount && grade.matchCount != 5) {
                gradeToReturn = grade;
            }
            if (matchCountInput == grade.matchCount && grade.matchBonus == isBonusMatch) {
                gradeToReturn = grade;
            }
        }
        return gradeToReturn;
    }
    
    @Override
    public String toString() {
        return condition + " (" + COMMA_IN_THREE.format(money) + "원)";
    }
    
    public long getMoney() {
        return money;
    }

}
