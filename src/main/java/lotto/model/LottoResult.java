package lotto.model;

import java.util.List;
import lotto.dto.LottoDto;

public class LottoResult {
    private static final int MIN_CORRECT_COUNT = 3;
    private static final int SECOND_GRADE_NUMBER_COUNT = 5;
    private static final String BONUS_GRADE = "+";
    private final Lotto winningLottoTicket;
    private final int bonusNumber;

    public LottoResult(List<Integer> numbers, int bonusNumber, LottoManager lottoManager) {
        winningLottoTicket = lottoManager.createWinningLottoTicket(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoGrade calculateGrade(LottoDto lottoDto) {
        long winningNumberCount = lottoDto.lotto().winningNumberCount(winningLottoTicket);

        if (isNotValidWinningNumberCount(winningNumberCount)) {
            return LottoGrade.NONE;
        }

        String grade = generateGrade(lottoDto, winningNumberCount);

        return LottoGrade.from(grade);
    }

    private boolean isNotValidWinningNumberCount(long winningNumberCount) {
        return winningNumberCount < MIN_CORRECT_COUNT;
    }

    private String generateGrade(LottoDto lottoDto, long winningNumberCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(winningNumberCount);

        if (isSecondGrade(lottoDto, winningNumberCount)) {
            sb.append(BONUS_GRADE);
        }

        return sb.toString();
    }

    private boolean isSecondGrade(LottoDto lottoDto, long winningNumberCount) {
        return (winningNumberCount == SECOND_GRADE_NUMBER_COUNT) && (lottoDto.lotto().isContainsNumber(bonusNumber));
    }
}