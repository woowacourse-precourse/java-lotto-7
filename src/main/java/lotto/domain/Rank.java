package lotto.domain;

public enum Rank {


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
        for (Rank rank : values()) {  // 모든 랭크를 순회
            // 매칭된 숫자와 보너스 매칭 여부를 확인
            if (rank.matchingCount == count && (!rank.requiresBonus || matchBonus)) {
                return rank;  // 조건에 맞는 랭크 반환
            }
        }

        // 조건에 맞는 랭크가 없을 경우 예외를 던짐
        throw new IllegalArgumentException("로또 번호에 매칭결과와 다른 예외적인 상황이 발생했습니다.");
    }
}
