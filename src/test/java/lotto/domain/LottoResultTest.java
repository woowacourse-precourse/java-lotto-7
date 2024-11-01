package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 결과가 제대로 초기화되는지 확인")
    @Test
    void 로또_결과_초기화를_확인한다() {
        LottoResult testLottoResult = LottoResult.initialize();
        Map<String, Integer> result = Map.of(
                "FIRST_PRIZE", 0,
                "SECOND_PRIZE", 0,
                "THIRD_PRIZE", 0,
                "FOURTH_PRIZE", 0,
                "FIFTH_PRIZE", 0
        );

        assertThat(testLottoResult.getResult()).isEqualTo(result);
    }

    @DisplayName("로또 결과가 정확한 결과를 반환하는지 확인한다.")
    @Test
    void 로또_결과를_확인한다() {
        LottoResult testLottoResult = LottoResult.initialize();
        testLottoResult.addResult(3, false);
        testLottoResult.addResult(3, true);
        testLottoResult.addResult(5, false);
        testLottoResult.addResult(5, true);

        Map<String, Integer> result = Map.of(
                "FIRST_PRIZE", 0,
                "SECOND_PRIZE", 1,
                "THIRD_PRIZE", 1,
                "FOURTH_PRIZE", 0,
                "FIFTH_PRIZE", 2
        );

        assertThat(testLottoResult.getResult()).isEqualTo(result);
    }
}
