package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Rank {

    FIFTH(3, 5_000, false),
    FOURTH(4,50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NONE(0, 0, false);

    private final int countNumber;
    private final int price;
    private final boolean needBonusNumber;

    Rank(int countNumber, int price, boolean needBonusNumber) {
        this.countNumber = countNumber;
        this.price = price;
        this.needBonusNumber = needBonusNumber;
    }

    public static Map<Rank, Integer> makeRankResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        Rank[] ranks = values();
        Arrays.stream(ranks)
            .forEach(rank -> result.put(rank, 0));
        return result;
    }

    public static Rank getRank(int countNumber, boolean needBonusNumber) {
        return Arrays.stream(values())
            .filter(rank -> rank.countNumber == countNumber
                && rank.needBonusNumber == needBonusNumber)
            .findFirst()
            .orElse(Rank.NONE);
    }

    public int getCountNumber() {
        return countNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean isNeedBonusNumber() {
        return needBonusNumber;
    }
}
