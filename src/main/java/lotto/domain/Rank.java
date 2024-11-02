/*
 * 클래스 이름 Rank
 *
 * 버전 정보 V1
 *
 * 날짜 9월 9일
 *
 * 저작권 주의
 */
package lotto.domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(1,6,false, 2000000000, (count,bonus) -> count == 6),
    SECOND(2,5,true,30000000,(count,bonus) -> count == 5 && bonus),
    THIRD(3,5,false,1500000, (count,bonus) -> count == 5 && !bonus),
    FOURTH(4,4,false,50000, (count,bonus) -> count == 4),
    FIFTH(5,3,false,5000, (count,bonus) -> count == 3),
    NON(0,0,false,0, (count,bonus) -> count <= 2);

    private final int rank;
    private final int count;
    private final boolean bonus;
    private final int reward;
    private final BiFunction<Integer,Boolean, Boolean> function;

    Rank(int rank,int count, boolean bonus, int reward, BiFunction<Integer, Boolean, Boolean> function) {
        this.rank = rank;
        this.count = count;
        this.bonus = bonus;
        this.reward = reward;
        this.function = function;
    }

    public int getReward() {
        return reward;
    }

    public Boolean getResult(int count, boolean bonus) {
        return function.apply(count,bonus);
    }

    public int getRank() {
        return rank;
    }
}
