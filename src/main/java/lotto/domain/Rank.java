package lotto.domain;

public enum Rank {

    FIRST(1, 2_000_000_000L),
    SECOND(2, 30_000_000L),
    THIRD(3, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(5, 5_000L),
    BLANK(6, 0L);

    final Integer rank;
    final Long prize;

    Rank(Integer rank, Long prize) {
        this.rank = rank;
        this.prize = prize;
    }

}
