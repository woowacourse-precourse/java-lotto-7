package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @DisplayName("각 숫자의 등장 횟수 테스트")
    @Test
    void 각_숫자의_등장_횟수_테스트() {
        List<Integer> matchResultList = List.of(3, 3, 4, 5, 5, 5, 6);

        Map<Integer, Long> result = LottoResultCalculator.countMatchingResults(matchResultList);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(Map.of(
                3, 2L,
                4, 1L,
                5, 3L,
                6, 1L
        ));
    }

    @DisplayName("필터링이 제대로 동작하는지 확인")
    @Test
    void 필터링이_제대로_동작하는지_확인() {
        List<Integer> matchResultList = List.of(1, 2, 3, 4, 6, 7, 8);

        Map<Integer, Long> result = LottoResultCalculator.countMatchingResults(matchResultList);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(Map.of(
                3, 1L,
                4, 1L,
                6, 1L
        ));
    }

    @DisplayName("빈 리스트를 제공했을때 빈 결과가 나오는지 테스트")
    @Test
    void 빈_결과가_나오는지_테스트() {
        List<Integer> matchResultList = List.of();

        Map<Integer, Long> result = LottoResultCalculator.countMatchingResults(matchResultList);

        assertThat(result).isEmpty();
    }
}