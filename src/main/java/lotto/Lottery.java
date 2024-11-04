package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 결과 출력 용
public enum Lottery {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int match;
    private final boolean isBonus;
    private final int price;

    Lottery(int match, boolean isBonus, int price) {
        this.match = match;
        this.isBonus = isBonus;
        this.price = price;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public boolean getBonus() {
        return isBonus;
    }

    public static Lottery getPriceByMatch(int match, boolean isBonus) {
        return Arrays.stream(Lottery.values())
                .filter(lottery -> lottery.match == match && lottery.isBonus == isBonus)
                .findAny()
                .get();
    }

    public static List<Lottery> getSortedByMatch() {
        return Arrays.stream(Lottery.values())
                .sorted(Comparator.comparingInt(Lottery::getMatch)) // match 값 기준 오름차순 정렬
                .toList();
    }
}
