package lotto.global.enums;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoRankTest {

    @ParameterizedTest
    @MethodSource("winningParams")
    @DisplayName("일치된 추첨 번호 수와 보너스 번호 수를 통해 WinningLottoRank 반환")
    void 당첨_로또_순위_반환_테스트(Integer drawnNumberMatchCount, Integer bonusNumberMatchCount,
                         WinningLottoRank expectedWinningLottoRank) {
        //given
        //when
        Optional<WinningLottoRank> winningLottoRank = WinningLottoRank.getRankMatchedBy(drawnNumberMatchCount,
                bonusNumberMatchCount);
        //then
        assertThat(winningLottoRank.isPresent()).isTrue();
        assertThat(winningLottoRank.get()).isEqualTo(expectedWinningLottoRank);
    }

    private static Stream<Arguments> winningParams() {
        return Stream.of(
                Arguments.of(6, 0, WinningLottoRank.FIRST_PLACE),
                Arguments.of(5, 1, WinningLottoRank.SECOND_PLACE),
                Arguments.of(5, 0, WinningLottoRank.THIRD_PLACE),
                Arguments.of(4, 0, WinningLottoRank.FOURTH_PLACE),
                Arguments.of(3, 0, WinningLottoRank.FIFTH_PLACE)
        );
    }

    @Test
    @DisplayName("일치된 추첨 번호 수와 보너스 번호 수가 순위권 밖인 경우 Optional에 객체가 존재하지 않음")
    void 당첨_로또_순위_반환_테스트2() {
        //given
        Integer drawnNumberMatchCount = 2;
        Integer bonusNumberMatchCount = 1;
        //when
        Optional<WinningLottoRank> winningLottoRank = WinningLottoRank.getRankMatchedBy(drawnNumberMatchCount,
                bonusNumberMatchCount);
        //then
        assertThat(winningLottoRank.isPresent()).isFalse();
    }

}