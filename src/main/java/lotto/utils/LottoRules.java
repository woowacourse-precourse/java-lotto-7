package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.utils.LottoRules.Winning.*;

public class LottoRules {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_PURCHASE_COUNT = 100;

    public static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE);
    }

    public enum Winning {
        WINNING_RANK_1(2_000_000_000),
        WINNING_RANK_2(30_000_000),
        WINNING_RANK_3(1_500_000),
        WINNING_RANK_4(50_000),
        WINNING_RANK_5(5_000),
        NO_RANK(0);

        private final int money;

        Winning(int money) {
            this.money = money;
        }

        public int getMoney() {
            return money;
        }
    }

    public static Winning determineWinningRank(int matchNumberCount, boolean bonusMatch) {
        if (matchNumberCount == LOTTO_NUMBER_SIZE) {
            return WINNING_RANK_1;
        }
        if (matchNumberCount == (LOTTO_NUMBER_SIZE - 1) && bonusMatch) {
            return WINNING_RANK_2;
        }
        if (matchNumberCount == (LOTTO_NUMBER_SIZE - 1)) {
            return WINNING_RANK_3;
        }
        if (matchNumberCount == (LOTTO_NUMBER_SIZE - 2)) {
            return WINNING_RANK_4;
        }
        if (matchNumberCount == (LOTTO_NUMBER_SIZE - 3)) {
            return WINNING_RANK_5;
        }
        return NO_RANK;
    }
}
