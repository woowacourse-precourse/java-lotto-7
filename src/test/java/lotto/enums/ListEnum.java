package lotto.enums;

import java.util.List;

public enum ListEnum {
    WINNING_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 5, 6)),
    THREE_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 7, 8, 9)),
    FOUR_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 8, 9)),
    FIVE_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 5, 9)),
    ;
    private final List<Integer> list;

    ListEnum(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }
}
