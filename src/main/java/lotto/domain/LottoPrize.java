package lotto.domain;

public enum LottoPrize {

    // 1등은 6개 일치, 2등은 5개 + 보너스 번호 일치, 3등 5개 일치
    // 위 세 등수를 구분하기 위해 1등과 2등은 '일치 숫자 개수'(matchNumber)를 1씩 증가시켰다.
    FIRST_PLACE(7, 2_000_000_000),
    SECOND_PLACE(6, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000);

    private int matchNumber;
    private int prize;

    private LottoPrize(int matchNumber, int prize){
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }
}
