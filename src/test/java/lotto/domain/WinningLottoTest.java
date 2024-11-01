package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.Rank;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {
    @Nested
    @DisplayName("당첨 로또를 생성할때")
    class winningLottoInitErrorTest {
        private final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        @ParameterizedTest
        @CsvSource(value = {"0", "46"})
        @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다")
        void winningLottoInitErrorTest(String outOfRangeNumber) {
            assertThatThrownBy(() -> new WinningLotto(ticket, Integer.parseInt(outOfRangeNumber)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 1와 45사이 숫자여야합니다.");
        }

        @Test
        @DisplayName("보너스 번호가 당첨로또 번호와 중복이 있다면 예외가 발생한다")
        void winningLottoDuplicateErrorTest() {
            assertThatThrownBy(() -> new WinningLotto(ticket, 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("로또 체크 할때")
    class winningLottoCheckLottoTest {
        private final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        public static Stream<Arguments> provideZeroRankLottoTestCases() {
            return Stream.of(
                    //로또번호가 0개 맞고 보너스가 맞지 않은 경우
                    Arguments.of(List.of(7, 8, 9, 10, 11, 12), 13, 0),
                    //로또번호가 1개 맞고 보너스 번호가 맞지 않은 경우
                    Arguments.of(List.of(6, 7, 8, 9, 10, 11), 12, 1),
                    //로또번호가 1개 맞고 보너스 번호도 맞은 경우
                    Arguments.of(List.of(6, 7, 8, 9, 10, 11), 7, 1),
                    //로또번호가 2개 맞고 보너스 번호가 맞지 않은 경우
                    Arguments.of(List.of(5, 6, 7, 8, 9, 10), 11, 2),
                    //로또번호가 2개 맞고 보너스 번호 맞은 경우
                    Arguments.of(List.of(5, 6, 7, 8, 9, 10), 7, 2)
            );
        }

        public static Stream<Arguments> provideFifthRankLottoTestCases() {
            return Stream.of(
                    //로또번호가 3개 맞고 보너스가 맞지 않은 경우
                    Arguments.of(List.of(4, 5, 6, 7, 8, 9), 10, 3),
                    //로또번호가 3개 맞고 보너스가 맞은 경우
                    Arguments.of(List.of(4, 5, 6, 7, 8, 9), 7, 3)
            );
        }

        public static Stream<Arguments> provideFourthRankLottoTestCases() {
            return Stream.of(
                    //로또번호가 4개 맞고 보너스가 맞지 않은 경우
                    Arguments.of(List.of(3, 4, 5, 6, 7, 8), 9, 4),
                    //로또번호가 4개 맞고 보너스가 맞은 경우
                    Arguments.of(List.of(3, 4, 5, 6, 7, 8), 8, 4)
            );
        }

        public static Stream<Arguments> provideThirdRankLottoTestCases() {
            return Stream.of(
                    //로또번호가 5개 맞고 보너스가 맞지 않은 경우
                    Arguments.of(List.of(2, 3, 4, 5, 6, 7), 8, 5)
            );
        }

        public static Stream<Arguments> provideSecondRankLottoTestCases() {
            return Stream.of(
                    //로또번호가 5개 맞고 보너스가 맞은 경우
                    Arguments.of(List.of(2, 3, 4, 5, 6, 7), 7, 5)
            );
        }

        @ParameterizedTest
        @MethodSource("provideZeroRankLottoTestCases")
        @DisplayName("NONE 랭크를 반환한다")
        void rankingNoneTest(List<Integer> numbers, int bonusNumber, int expectedMatchCount) {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, bonusNumber);
            Lotto newTicket = new Lotto(numbers);
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
            assertThat(result.getRank()).isEqualTo(Rank.NONE);
        }

        @ParameterizedTest
        @MethodSource("provideFifthRankLottoTestCases")
        @DisplayName("FIFTH 랭크를 반환한다")
        void rankingFifthTest(List<Integer> numbers, int bonusNumber, int expectedMatchCount) {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, bonusNumber);
            Lotto newTicket = new Lotto(numbers);
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
            assertThat(result.getRank()).isEqualTo(Rank.FIFTH);
        }

        @ParameterizedTest
        @MethodSource("provideFourthRankLottoTestCases")
        @DisplayName("FOURTH 랭크를 반환한다")
        void rankingFourthTest(List<Integer> numbers, int bonusNumber, int expectedMatchCount) {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, bonusNumber);
            Lotto newTicket = new Lotto(numbers);
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
            assertThat(result.getRank()).isEqualTo(Rank.FOURTH);
        }

        @Test
        @DisplayName("로또번호가 5개 맞고 보너스가 맞지 않은 경우 THIRD 랭크를 반환한다")
        void rankingThirdTest() {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, 8);
            Lotto newTicket = new Lotto(List.of(2, 3, 4, 5, 6, 7));
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(5);
            assertThat(result.getRank()).isEqualTo(Rank.THIRD);
        }

        @Test
        @DisplayName("로또번호가 5개 맞고 보너스가 맞은 경우 SECOND 랭크를 반환한다")
        void rankingSecondTest() {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, 7);
            Lotto newTicket = new Lotto(List.of(2, 3, 4, 5, 6, 7));
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(5);
            assertThat(result.getRank()).isEqualTo(Rank.SECOND);
        }

        @Test
        @DisplayName("로또번호가 5개 맞고 보너스가 맞지 않은 경우 FIRST 랭크를 반환한다")
        void rankingFirstTest() {
            // given
            WinningLotto winningLotto = new WinningLotto(ticket, 7);
            Lotto newTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            // when
            LottoResult result = winningLotto.checkLotto(newTicket);
            // then
            assertThat(result.getMatchCount()).isEqualTo(6);
            assertThat(result.getRank()).isEqualTo(Rank.FIRST);
        }

    }


}