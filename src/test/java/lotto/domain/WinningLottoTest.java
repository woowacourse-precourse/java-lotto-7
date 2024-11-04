package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.Rank;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    @Nested
    @DisplayName("당첨 로또 체크 테스트")
    class WinningLottoCheckLottoTest {
        private final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        private final Lotto ticket = Lotto.of(winningLottoNumbers);

        private static Stream<Arguments> provideLottoRankTestCases() {
            return Stream.of(
                    // NONE 랭크
                    Arguments.of("로또 번호 0개 맞고 보너스도 맞지 않을때 None 랭크를 반환한다"
                            , java.util.List.of(7, 8, 9, 10, 11, 12), 13, Rank.NONE),
                    Arguments.of("로또 번호 1개 맞고 보너스도 맞지 않을때 None 랭크를 반환한다"
                            , java.util.List.of(6, 7, 8, 9, 10, 11), 12, Rank.NONE),
                    Arguments.of("로또 번호 1개 맞고 보너스 번호 맞을때 None 랭크를 반환한다"
                            , List.of(6, 7, 8, 9, 10, 11), 7, Rank.NONE),
                    Arguments.of("로또 번호 2개 맞고 보너스도 맞지 않을때 None 랭크를 반환한다"
                            , List.of(5, 6, 7, 8, 9, 10), 11, Rank.NONE),
                    Arguments.of("로또 번호 2개 맞고 보너스 번호 맞을때 None 랭크를 반환한다"
                            , List.of(5, 6, 7, 8, 9, 10), 7, Rank.NONE),
                    // FIFTH 랭크
                    Arguments.of("로또 번호 3개 맞고 보너스도 맞지 않을때 FIFTH 랭크를 반환한다"
                            , List.of(4, 5, 6, 7, 8, 9), 10, Rank.FIFTH),
                    Arguments.of("로또 번호 3개 맞고 보너스 번호 맞을때 FIFTH 랭크를 반환한다"
                            , List.of(4, 5, 6, 7, 8, 9), 7, Rank.FIFTH),
                    // FOURTH 랭크
                    Arguments.of("로또 번호 4개 맞고 보너스도 맞지 않을때 FOURTH 랭크를 반환한다"
                            , List.of(3, 4, 5, 6, 7, 8), 9, Rank.FOURTH),
                    Arguments.of("로또 번호 4개 맞고 보너스 번호 맞을때 FOURTH 랭크를 반환한다"
                            , List.of(3, 4, 5, 6, 7, 8), 8, Rank.FOURTH),
                    // THIRD 랭크
                    Arguments.of("로또 번호 5개 맞고 보너스도 맞지 않을때 THIRD 랭크를 반환한다"
                            , List.of(2, 3, 4, 5, 6, 7), 8, Rank.THIRD),
                    // SECOND 랭크
                    Arguments.of("로또 번호 5개 맞고 보너스 번호 맞을때 SECOND 랭크를 반환한다"
                            , List.of(2, 3, 4, 5, 6, 7), 7, Rank.SECOND),
                    // FIRST 랭크
                    Arguments.of("로또 번호 6개 맞을때 FIRST 랭크를 반환한다"
                            , List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIRST)
            );
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("provideLottoRankTestCases")
        @DisplayName("로또 결과를 검증시")
        void rankingTest(String description, List<Integer> customerLottoNumbers, int bonusNumber, Rank expectedRank) {
            // given
            BonusNumber bonusNum = BonusNumber.of(bonusNumber, winningLottoNumbers);
            WinningLotto winningLotto = WinningLotto.of(ticket, bonusNum);
            Lotto newTicket = Lotto.of(customerLottoNumbers);

            // when
            LottoResult result = winningLotto.checkLotto(newTicket);

            // then
            assertThat(result.getRank()).isEqualTo(expectedRank);
        }
    }

}