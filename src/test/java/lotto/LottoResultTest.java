package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.model.LottoGrade;
import lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("초기화 시 모든 등수는 0으로 설정된다.")
    void 초기화_시_모든_등수의_개수는_0으로_초기화_한다() {
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.FIRST_GRADE));
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.SECOND_GRADE));
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.THIRD_GRADE));
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.FOURTH_GRADE));
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.FIFTH_GRADE));
    }

    @Test
    @DisplayName("등수를 추가하면 해당 등수의 카운트가 증가한다.")
    void 등수를_추가하면_해당_등수의_카운트가_증가한다() {
        lottoResult.addGrade(LottoGrade.FIRST_GRADE);
        lottoResult.addGrade(LottoGrade.SECOND_GRADE);
        lottoResult.addGrade(LottoGrade.SECOND_GRADE);

        assertEquals(1, lottoResult.getGradeCount(LottoGrade.FIRST_GRADE));
        assertEquals(2, lottoResult.getGradeCount(LottoGrade.SECOND_GRADE));
        assertEquals(0, lottoResult.getGradeCount(LottoGrade.THIRD_GRADE));
    }
}
