package lotto;

public enum Ranking {
    FIRST(6, false, 20000000000L),
    SECOND(5, true, 300000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L);

    private final int match;
    private final boolean hasBonus;
    private final long prize;

    Ranking(int match, boolean hasBonus, long prize) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public int getMatch(){
        return match;
    }
    public long getPrize(){
        return prize;
    }

    //상금 계산
    public long Prizes(int score){
        return prize * score;
    }
}



/*
    > - 1등 : 6개 번호 일치 / 2,000,000,000원
    > - 2등 : 5개 번호 + 보너스 번호 일치 / 30,000,000원
    > - 3등 : 5개 번호 일치 / 1,500,000원
    > - 4등 : 4개 번호 일치 / 50,000원
    > - 5등 : 3개 번호 일치 / 5,000원*/
