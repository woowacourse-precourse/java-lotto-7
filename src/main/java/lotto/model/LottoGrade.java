package lotto.model;

import lotto.error.CustomException;
import lotto.error.ExceptionMessage;

public enum LottoGrade {
    FIRST_GRADE(1, 6, 2000000000),
    SECOND_GRADE(2, 5, 30000000),
    THIRD_GRADE(3, 5, 1500000),
    FOURTH_GRADE(4, 4, 50000),
    FIFTH_GRADE(5, 3, 5000),
    SIXTH_GRADE(6, 2, 0),
    SEVENTH_GRADE(7, 1, 0),
    ;

    private final int ranking;
    private final int correctCount;
    private final int prize;

    LottoGrade(int ranking, int correctCount, int prize) {
        this.ranking = ranking;
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public int getRanking() {
        return ranking;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoGrade getGrade(int correctCount, boolean isCorrectBonus) {
        return switch (correctCount) {
            case 1 -> SEVENTH_GRADE;
            case 2 -> SIXTH_GRADE;
            case 3 -> FIFTH_GRADE;
            case 4 -> FOURTH_GRADE;
            case 5 -> isCorrectBonus ? SECOND_GRADE : THIRD_GRADE;
            case 6 -> FIRST_GRADE;
            default -> throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_CORRECT_COUNT);
        };
    }

}
