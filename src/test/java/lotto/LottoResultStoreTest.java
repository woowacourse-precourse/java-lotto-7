package lotto;

import lotto.lottoMachine.utils.LottoResultStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoResultStoreTest {
    private LottoResultStore lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new LottoResultStore();
    }

    @DisplayName("초기화 후 모든 결과가 0으로 설정되어 있는지 테스트")
    @Test
    void 초기화_후_모든_결과가_0으로_설정되어_있는지_테스트() {
        // Given & When
        Map<LottoResultStructure, Integer> results = lottoResultStore.getResults();

        // Then
        for (LottoResultStructure lottoWinninRank : LottoResultStructure.values()) {
            assertThat(results.get(lottoWinninRank)).isEqualTo(0);
        }
    }

    @DisplayName("로또 당첨 결과를 저장하는 메서드가 올바르게 동작하는지 테스트")
    @Test
    void 로또_당첨_결과를_저장하는_메서드가_올바르게_동작하는지_테스트() {
        // Given
        lottoResultStore.store(3, false);
        lottoResultStore.store(4, false);
        lottoResultStore.store(5, false);
        lottoResultStore.store(5, true);
        lottoResultStore.store(6, false);

        // When
        Map<LottoResultStructure, Integer> results = lottoResultStore.getResults();

        // Then
        assertThat(results.get(LottoResultStructure.FIFTH)).isEqualTo(1);
        assertThat(results.get(LottoResultStructure.FOURTH)).isEqualTo(1);
        assertThat(results.get(LottoResultStructure.THIRD)).isEqualTo(1);
        assertThat(results.get(LottoResultStructure.SECOND)).isEqualTo(1);
        assertThat(results.get(LottoResultStructure.FIRST)).isEqualTo(1);
    }

    @DisplayName("getResults 메서드가 불변 맵을 반환하는지 테스트")
    @Test
    void getResults_메서드가_불변_맵을_반환하는지_테스트() {
        // Given
        Map<LottoResultStructure, Integer> results = lottoResultStore.getResults();

        // Then
        assertThrows(UnsupportedOperationException.class, () -> results.put(LottoResultStructure.FIFTH, 10));
    }
}
