package lotto.domain;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    // true : 보너스 번호 요구 O , false : 보너스 번호 요구 X
    private final boolean requiresBonus;

    // 보너스 필요하지 않은 랭크를 위한 생성자
    Rank(int matchingCount, int prize) {
        this(matchingCount, prize, false);  // 보너스 필요 여부를 false로 설정
    }

    // 보너스 필요 여부를 포함한 생성자
    Rank(int matchingCount, int prize, boolean requiresBonus) {
        this.matchingCount = matchingCount;  // 매칭된 숫자 수 초기화
        this.prize = prize;  // 상금 초기화
        this.requiresBonus = requiresBonus;  // 보너스 필요 여부 초기화
    }


    public int getPrize(){
        return prize;
    }

    // 매칭된 숫자와 보너스 매칭 여부에 따라 랭크를 결정하는 정적 메서드
    public static Rank valueOf(int count, boolean matchBonus) {
        if (count < 3) { // 2개 이하일 경우 NONE으로 처리
            return NONE;
        }

        for (Rank rank : values()) {
            if (rank.matchingCount == count && (!rank.requiresBonus || matchBonus)) {
                return rank;
            }
        }

        throw new IllegalArgumentException("로또 번호에 매칭결과와 다른 예외적인 상황이 발생했습니다.");
    }

    public int getMatchingCount() {
        return matchingCount;
    }

}