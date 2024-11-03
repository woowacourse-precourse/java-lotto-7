package lotto.domain;

import static lotto.domain.LottoPrize.NO_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @Test
    @DisplayName("당첨 Enum에 대해 각 등수별 설명이 제대로 나오는 지 테스트")
    public void 당첨_enum_설명_테스트() {
        // Given
        String expectedEnumString = """
                3개 일치 (5,000원)
                4개 일치 (50,000원)
                5개 일치 (1,500,000원)
                5개 일치, 보너스 볼 일치 (30,000,000원)
                6개 일치 (2,000,000,000원)""";

        // When
        String resultLottoPrizeToString = Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != NO_PRIZE)
                .sorted(Comparator.comparingLong(LottoPrize::getPrizeMoney))
                .map(LottoPrize::toString)
                .collect(Collectors.joining("\n"));

        // Then
        assertThat(resultLottoPrizeToString).isEqualTo(expectedEnumString);
    }

}