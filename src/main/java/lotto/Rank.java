// 순위에 맞게 당첨금 반환하는 메서드
// 당첨된 로또 개수 저장
//- FIFTH = 5,000
//- FOURTH = 50,000
//- THIRD = 1,500,500
//- SECOND = 30,000,000
//- FIRST = 2,000,000,000

package lotto;

public enum Rank {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500500),
    SECOND(30000000),
    FIRST(2000000000);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public int getPrize() { return prize; }
}