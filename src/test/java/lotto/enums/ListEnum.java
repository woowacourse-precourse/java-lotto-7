package lotto.enums;

import java.util.List;
import lotto.domain.DrawNumbers;

public enum ListEnum {
    WINNING_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 5, 6)),
    THREE_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 7, 8, 9)),
    FOUR_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 8, 9)),
    FIVE_MATCH_LOTTO_NUMBERS(List.of(1, 2, 3, 4, 5, 9)),
    ;
    private final List<Integer> list;
    private static List<DrawNumbers> drawSets;

    ListEnum(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public static List<DrawNumbers> getDrawSets() {
        //random drawn numbers set
        DrawNumbers threeMatchNumber = new DrawNumbers(
                ListEnum.THREE_MATCH_LOTTO_NUMBERS.getList(),
                IntEnum.NOT_MATCH_BONUS_NUMBERS.getNumber()
        );
        DrawNumbers fourMatchNumber = new DrawNumbers(
                ListEnum.FOUR_MATCH_LOTTO_NUMBERS.getList(),
                IntEnum.NOT_MATCH_BONUS_NUMBERS.getNumber()
        );
        DrawNumbers fiveMatchNumber = new DrawNumbers(
                ListEnum.FIVE_MATCH_LOTTO_NUMBERS.getList(),
                IntEnum.NOT_MATCH_BONUS_NUMBERS.getNumber()
        );
        DrawNumbers fiveMatchWithBonusNumber = new DrawNumbers(
                ListEnum.FIVE_MATCH_LOTTO_NUMBERS.getList(),
                IntEnum.WINNING_BONUS_NUMBERS.getNumber()
        );
        DrawNumbers sixMatchNumber = new DrawNumbers(
                ListEnum.WINNING_LOTTO_NUMBERS.getList(),
                IntEnum.NOT_MATCH_BONUS_NUMBERS.getNumber()
        );

        drawSets = List.of(
                threeMatchNumber,
                fourMatchNumber,
                fiveMatchNumber,
                fiveMatchWithBonusNumber,
                sixMatchNumber
        );
        return drawSets;
    }
}
