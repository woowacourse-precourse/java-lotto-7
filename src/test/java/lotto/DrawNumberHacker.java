package lotto;

import lotto.model.draw_numbers.DrawNumbers;

import java.util.List;

public enum DrawNumberHacker {

    HACK_FIRST_PLACE(new DrawNumbers( List.of(1,2,3,4,5,6),  DrawNumberHacker.UNKNOWN_BONUS_NUMBER)),
    HACK_SECOND_PLACE(new DrawNumbers(List.of(1,2,3,4,5,7),  hackedBonusNumber())),
    HACK_THIRD_PLACE(new DrawNumbers( List.of(1,2,3,4,5,7),  DrawNumberHacker.UNKNOWN_BONUS_NUMBER)),
    HACK_FOURTH_PLACE(new DrawNumbers(List.of(1,2,3,4,7,8),  DrawNumberHacker.UNKNOWN_BONUS_NUMBER)),
    HACK_FIFTH_PLACE(new DrawNumbers( List.of(1,2,3,7,8,9),  DrawNumberHacker.UNKNOWN_BONUS_NUMBER));

    public static final int MIN_WINNING_NUMBER   = 1;
    public static final int MAX_WINNING_NUMBER   = 6;
    public static final int UNKNOWN_BONUS_NUMBER = 45;

    private final DrawNumbers drawNumbers;

    DrawNumberHacker(DrawNumbers drawNumbers) {
        this.drawNumbers = drawNumbers;
    }

    public DrawNumbers getDrawNumbers() {
        return drawNumbers;
    }

    private static int hackedBonusNumber() {
        return DrawNumberHacker.MAX_WINNING_NUMBER;
    }
}
