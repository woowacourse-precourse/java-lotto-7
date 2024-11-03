package lotto;

import java.util.Arrays;

public enum CorrectStatus {

    THREE_CORRECT("3개 일치 (5,000원) - ",5000,3,false),
    FOUR_CORRECT("4개 일치 (50,000원) - ",50000,4,false),
    FIVE_CORRECT_WITH_NO_SPECIAL_NUMBER("5개 일치 (1,500,000원) - ",1500000,5,false),
    FIVE_CORRECT_WITH_SPECIAL_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000,5,true),
    SIX_CORRECT("6개 일치 (2,000,000,000원) - ",2000000000,6,false);

    private String message;

    private int reward;

    private int matchCount;

    private boolean validSpecialBonus;

    CorrectStatus(final String message, final int reward,final int matchCount,final boolean validSpecialBonus){
        this.message = message;
        this.reward = reward;
        this.matchCount = matchCount;
        this.validSpecialBonus = validSpecialBonus;
    }

    public static CorrectStatus findByMatchCountAndSpecialNumber(final int matchCount,final boolean containSpecialNumber){
        return Arrays.stream(CorrectStatus.values())
                .filter(status -> {
                    if(matchCount == 5){
                        if(containSpecialNumber){
                            return status.validSpecialBonus;
                        }
                        return status.matchCount == matchCount && !status.validSpecialBonus;
                    }

                    return status.matchCount == matchCount;
                })
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching CorrectStatus for match count: " + matchCount));
    }

    public String getMessage(){
        return this.message;
    }
    public int getReward(){
        return this.reward;
    }
    public int getMatchCount(){
        return this.matchCount;
    }



}
