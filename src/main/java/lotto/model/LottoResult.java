package lotto.model;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoGrade, Integer> grades = new HashMap<>();

    public LottoResult() {
        grades.put(LottoGrade.EIGHTH_GRADE, 0);
        grades.put(LottoGrade.SEVENTH_GRADE, 0);
        grades.put(LottoGrade.SIXTH_GRADE, 0);
        grades.put(LottoGrade.FIFTH_GRADE, 0);
        grades.put(LottoGrade.FOURTH_GRADE, 0);
        grades.put(LottoGrade.THIRD_GRADE, 0);
        grades.put(LottoGrade.SECOND_GRADE, 0);
        grades.put(LottoGrade.FIRST_GRADE, 0);
    }

    public void addGrade(LottoGrade grade) {
        grades.put(grade, grades.get(grade) + 1);
    }

    public int getGradeCount(LottoGrade grade) {
        return grades.get(grade);
    }
}
