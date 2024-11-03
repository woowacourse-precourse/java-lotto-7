package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 결과 출력 용
public enum Lottery {
    THREE(3, false, "(5,000원)"),
    FOUR(4, false, "(50,000원)"),
    FIVE(5, false, "(1,500,000원)"),
    FIVE_BONUS(5, true, ", 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, "(2,000,000,000원)");

    private final int match;
    private final boolean isBonus;
    private final String price;

    Lottery(int match, boolean isBonus, String price) {
        this.match = match;
        this.isBonus = isBonus;
        this.price = price;
    }

    public int getMatch() {
        return match;
    }

    public String getPrice() {
        return price;
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
