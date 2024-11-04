package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("LottoResult 객체가 올바르게 생성되는지 테스트")
    @Test
    void LottoResult_객체가_올바르게_생성되는지_테스트() {
        // Given
        int expectedMatchingCount = 5;
        boolean expectedMatchBonus = true;

        // When
        LottoResult lottoResult = new LottoResult(expectedMatchingCount, expectedMatchBonus);

        // Then
        assertThat(lottoResult.getMatchingCount()).isEqualTo(expectedMatchingCount);
        assertThat(lottoResult.isMatchBonus()).isEqualTo(expectedMatchBonus);
    }

    @DisplayName("LottoResult의 matchingCount가 정확히 반환되는지 테스트")
    @Test
    void LottoResult의_matchingCount가_정확히_반환되는지_테스트() {
        // Given
        LottoResult lottoResult = new LottoResult(4, false);

        // When
        int matchingCount = lottoResult.getMatchingCount();

        // Then
        assertThat(matchingCount).isEqualTo(4);
    }

    @DisplayName("LottoResult의 matchBonus가 정확히 반환되는지 테스트")
    @Test
    void LottoResult의_matchBonus가_정확히_반환되는지_테스트() {
        // Given
        LottoResult lottoResult = new LottoResult(4, true);

        // When
        boolean matchBonus = lottoResult.isMatchBonus();

        // Then
        assertThat(matchBonus).isTrue();
    }
}
