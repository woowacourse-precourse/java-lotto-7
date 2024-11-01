package lotto.domain;

public class RankDecider {

    public static int getRank( MatchResult matchResult ) {
        int matchedNumberCount =  matchResult.getMatchedNumberCount();
        boolean isBonusNumberMatched = matchResult.isBonusNumberMatched();

        if(matchedNumberCount < 3){ return -1;}
        if(matchedNumberCount == 3){ return 5;}
        if(matchedNumberCount == 4){ return 4;}
        if(matchedNumberCount == 5 && !isBonusNumberMatched){ return 3;}
        if(matchedNumberCount == 5){ return 2;}

        return 1;
    }

}
