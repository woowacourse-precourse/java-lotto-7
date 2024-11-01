package lotto.domain;

import java.util.Map;

class LottoConstants {
    // LottoGenerator 클래스
    static final int NUMBER_OF_NUMBERS = 6;
    static final int RANDOM_MIN = 1;
    static final int RANDOM_MAX = 45;

    // LottoService 클래스
    static final long LOTTO_PRICE = 1000L;
    static final int PERCENT = 100;
    static final int PLACE_TO_ROUND_TO = 1;
    static final int SECOND_RANK_MATCH_COUNT = 5;
    static final int NUMBER_OF_RANKS = 5;
    static final int INITIAL_WINNING_COUNT = 0;
    static final int FIRST_RANK = 1;

    // (n, m) n개 일치 시 m등
    static final Map<Integer, Integer> MATCH_COUNT_TO_RANK = Map.of(
            6, 1,
            5, 3,
            4, 4,
            3, 5
    );

    // (m, k) m등 상금 k원
    static final Map<Integer, Integer> PRIZE_AMOUNT_BY_RANK = Map.of(
            1, 2000000000,
            2, 30000000,
            3, 1500000,
            4, 50000,
            5, 5000
    );
}
