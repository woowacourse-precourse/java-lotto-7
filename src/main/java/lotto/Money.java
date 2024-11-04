package lotto;

public enum Money {
    NONE(0, false,0),                  // 등수 없음: 상금 0원
    FIFTH(3, false,5000),              // 5등: 3개 번호 일치 5,000원
    FOURTH(4, false,50000),            // 4등: 4개 번호 일치 50,000원
    THIRD(5, false,1500000),           // 3등: 5개 번호 일치 1,500,000원
    SECOND(5, true, 30000000),          // 2등: 5개 번호 + 보너스 번호 일치 30,000,000원
    FIRST(6,false, 2000000000);        // 1등: 6개 번호 일치 2,000,000,000원


    private final int matchedCount;      // 일치 수
    private final boolean bonus;        //2등
    private final int prize;           // 상금

    // 생성자
    Money(int matchedCount,boolean bonus, int prize) {
        this.matchedCount = matchedCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }
}