package lotto.model;

import lotto.error.CustomException;
import lotto.error.ExceptionMessage;

public enum LottoGrade {
    EIGHTH_GRADE(8, 0, 0),
    SEVENTH_GRADE(7, 1, 0),
    SIXTH_GRADE(6, 2, 0),
    FIFTH_GRADE(5, 3, 5000),
    FOURTH_GRADE(4, 4, 50000),
    THIRD_GRADE(3, 5, 1500000),
    SECOND_GRADE(2, 5, 30000000),
    FIRST_GRADE(1, 6, 2000000000);

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
        if (isCorrectBonus && correctCount == SECOND_GRADE.getCorrectCount()) {
            return SECOND_GRADE;
        }
        for (LottoGrade grade : LottoGrade.values()) {
            if (grade.getCorrectCount() == correctCount) {
                return grade;
            }
        }
        throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_CORRECT_COUNT);
    }

}
