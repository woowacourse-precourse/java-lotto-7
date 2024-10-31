package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.model.LottoResults;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {
    @Test
    void 로또_결과_계산_테스트() {
        LottoResults lottoResults = new LottoResults();
        int Winnings = lottoResults.calculateResult(Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 10, 11, 12));
        // 결과: 3개 일치
        assertEquals(3, Winnings, "일치하는 번호 개수가 3이어야 합니다.");
    }
}
