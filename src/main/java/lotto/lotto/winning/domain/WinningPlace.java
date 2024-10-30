package lotto.lotto.domain.winning.domain;

import lotto.buyer.domain.Money;
import lotto.buyer.infrastructure.Won;
import lotto.lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningPlace {
    FIRST_PLACE(6, Won.of(2_000_000_000L), 0, "6개 일치 (2,000,000,000원)", 5),
    SECOND_PLACE(6, Won.of(30_000_000L), 0, "5개 일치, 보너스 볼 일치 (30,000,000원)",4) {
        @Override
        public boolean isWinning(WinningLotto winningLotto, BonusNumber bonusNumber, Lotto lotto) {
            int matchCount = lotto.getMatchWinningCountAndBonusNumber(winningLotto, bonusNumber);
            return matchesWinningCount(matchCount);
        }
    },
    THIRD_PLACE(5, Won.of(1_500_000L), 0, "5개 일치 (1,500,000원)",3),
    FOURTH_PLACE(4, Won.of(50_000L), 0, "4개 일치 (50,000원)",2),
    FIFTH_PLACE(3, Won.of(5_000L), 0,"3개 일치 (5,000원)",1),
    LAST_PLACE(0, Won.of(0L), 0, "", 0);
    private static final WinningPlace[] WINNING_PLACES = values();
    private final int winningNumber;
    private final Money money;
    private int count;
    private final String info;
    private final int sequence;
    WinningPlace(int winningNumber, Money money, int count, String info, int sequence) {
        this.winningNumber = winningNumber;
        this.money = money;
        this.count = count;
        this.info = info;
        this.sequence = sequence;
    }
    public static String print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(WINNING_PLACES)
                .sorted(Comparator.comparing((winningPlace) -> winningPlace.sequence))
                .filter((winningCost) -> winningCost != LAST_PLACE)
                .forEach((winningCost) ->
                        sb.append(winningCost.info)
                                .append(" - ")
                                .append(winningCost.count)
                                .append("개\n"));
        return sb.toString();
    }
    public static Money calculate(WinningLotto winningLotto, BonusNumber bonusNumber,  Lotto lotto) {
        return Arrays.stream(WINNING_PLACES)
                .filter((winningPlace) -> winningPlace.isWinning(winningLotto, bonusNumber, lotto))
                .findFirst()
                .map((winningPlace) -> {
                    winningPlace.incrementCount();
                    return winningPlace.money;
                })
                .orElse(LAST_PLACE.money);
    }
    public boolean matchesWinningCount(int number) {
        return winningNumber == number;
    }
    public boolean isWinning(WinningLotto winningLotto, BonusNumber bonusNumber, Lotto lotto) {
        int matchCount = lotto.getMatchWinningCount(winningLotto);
        return matchesWinningCount(matchCount);
    }
    private void incrementCount() {
        this.count++;
    }
}
