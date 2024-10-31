package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoCriteriaTest {

    @Nested
    @DisplayName("일치하는 로또번호 갯수와 보너스 번호로 당첨 등수를 찾는 로직 테스트")
    class whenFindPrizeByEqualLottoCountAndIsContainBonus {

        @ParameterizedTest
        @CsvSource({"true", "false"})
        @DisplayName("일치하는 로또 번호 갯수 - 6, 보너스 번호 - true or false")
        void when6AndTrueOrFalseThenReturnFirstPrize(Boolean isContainBonus) {
            //given
            int equalLottoCount = 6;
            WinningLottoCriteria expected = WinningLottoCriteria.FIRST_PRIZE;

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertAll(
                    () -> assertThat(actual.isPresent()).isEqualTo(true),
                    () -> actual.ifPresent(
                            winningLottoCriteria -> assertThat(winningLottoCriteria).isEqualTo(expected)
                    )

            );
        }

        @Test
        @DisplayName("일치하는 로또 번호 갯수 - 5, 보너스 번호 - true")
        void when5AndTrueThenReturnSecondPrize() {
            //given
            int equalLottoCount = 5;
            boolean isContainBonus = true;
            WinningLottoCriteria expected = WinningLottoCriteria.SECOND_PRIZE;

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertAll(
                    () -> assertThat(actual.isPresent()).isEqualTo(true),
                    () -> actual.ifPresent(
                            winningLottoCriteria -> assertThat(winningLottoCriteria).isEqualTo(expected)
                    )

            );
        }

        @Test
        @DisplayName("일치하는 로또 번호 갯수 - 5, 보너스 번호 - false")
        void when5AndFalseThenReturnThirdPrize() {
            //given
            int equalLottoCount = 5;
            boolean isContainBonus = false;
            WinningLottoCriteria expected = WinningLottoCriteria.THIRD_PRIZE;

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertAll(
                    () -> assertThat(actual.isPresent()).isEqualTo(true),
                    () -> actual.ifPresent(
                            winningLottoCriteria -> assertThat(winningLottoCriteria).isEqualTo(expected)
                    )

            );
        }

        @ParameterizedTest
        @CsvSource({"true", "false"})
        @DisplayName("일치하는 로또 번호 갯수 - 4, 보너스 번호 - true or false")
        void when4AndTrueOrFalseThenReturnFirstPrize(Boolean isContainBonus) {
            //given
            int equalLottoCount = 4;
            WinningLottoCriteria expected = WinningLottoCriteria.FOURTH_PRIZE;

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertAll(
                    () -> assertThat(actual.isPresent()).isEqualTo(true),
                    () -> actual.ifPresent(
                            winningLottoCriteria -> assertThat(winningLottoCriteria).isEqualTo(expected)
                    )

            );
        }

        @ParameterizedTest
        @CsvSource({"true", "false"})
        @DisplayName("일치하는 로또 번호 갯수 - 3, 보너스 번호 - true or false")
        void when3AndTrueOrFalseThenReturnFirstPrize(Boolean isContainBonus) {
            //given
            int equalLottoCount = 3;
            WinningLottoCriteria expected = WinningLottoCriteria.FIFTH_PRIZE;

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertAll(
                    () -> assertThat(actual.isPresent()).isEqualTo(true),
                    () -> actual.ifPresent(
                            winningLottoCriteria -> assertThat(winningLottoCriteria).isEqualTo(expected)
                    )

            );
        }

        @ParameterizedTest
        @CsvSource(value = {"0:true", "0:false", "1:true", "1:false", "2:true", "2:false"}, delimiter = ':')
        @DisplayName("당첨되지 않는 경우 Optional 빈객체 반환")
        void whenAllOtherCaseThenReturnOptionalEmpty(int equalLottoCount, Boolean isContainBonus) {
            //given
            Optional<WinningLottoCriteria> expected = Optional.empty();

            //when
            Optional<WinningLottoCriteria> actual = WinningLottoCriteria.findPrize(equalLottoCount, isContainBonus);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
