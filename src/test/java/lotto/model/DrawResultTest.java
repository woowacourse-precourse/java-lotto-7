package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.constant.DrawType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DrawResultTest {

    @ParameterizedTest
    @CsvSource({
            "1, false, 0",
            "2, false, 0",
            "3, false, 3",
            "4, false, 4",
            "5, false, 5",
            "5, true, 5B",
            "6, false, 6",
    })
    @DisplayName("로또 추첨 결과를 추첨 종류에 따라 포맷한다.")
    void 로또_추첨_결과_포맷_테스트(int result, boolean hasBonusResult, String expectedResult) {
        // given
        DrawResult drawResult = new DrawResult(result, hasBonusResult);

        // when
        DrawType formatResult = drawResult.formatDrawResult();

        // then
        assertThat(formatResult.getValue()).isEqualTo(expectedResult);
    }

}
