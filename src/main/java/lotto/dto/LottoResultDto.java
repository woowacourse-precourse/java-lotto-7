package lotto.dto;

import lotto.model.LottoGrade;

public record LottoResultDto(
        LottoGrade grade,
        String correct,
        int amount,
        int winningCount
) {
    public static LottoResultDto of(LottoGrade grade, int winningCount) {
        return new LottoResultDto(grade, grade.getCorrect(), grade.getAmount(), winningCount);
    }
}