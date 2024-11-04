package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {
    @Nested
    class TestConstructor {
        @Test
        void should_create() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(8);

            // when, then
            assertThatCode(() -> new LottoResult(winningNumbers, bonusNumber)).doesNotThrowAnyException();
        }

        @Test
        void should_throw_when_has_common_number() {
            // given
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(5);

            // when, then
            assertThatThrownBy(() -> new LottoResult(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    @Nested
    class TestCountMatch {
        static Stream<Arguments> generateShouldReturnCountArguments() {
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(7);
            LottoResult lhs = new LottoResult(winningNumbers, bonusNumber);

            Function<List<Integer>, Lotto> mapper = numbers -> {
                List<LottoNumber> lottoNumbers = numbers.stream()
                        .map(LottoNumber::new).toList();
                return new Lotto(lottoNumbers);
            };

            return Stream.of(
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 6)), 6),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 7)), 5),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 7)), 5),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 8)), 5),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 7, 8)), 4),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 7, 8, 9)), 3),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 7, 8, 9, 10)), 2),
                    Arguments.of(lhs, mapper.apply(List.of(1, 7, 8, 9, 10, 11)), 1),
                    Arguments.of(lhs, mapper.apply(List.of(7, 8, 9, 10, 11, 12)), 0));
        }

        @ParameterizedTest
        @MethodSource("generateShouldReturnCountArguments")
        void should_return_count(LottoResult lottoResult, Lotto lotto, long expected) {
            // when
            long count = lottoResult.countMatch(lotto);

            // then
            assertThat(count).isEqualTo(expected);
        }
    }

    @Nested
    class TestCheckBonus {
        static Stream<Arguments> generateShouldReturnCheckBonusArguments() {
            WinningNumbers winningNumbers =
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList());
            LottoNumber bonusNumber = new LottoNumber(7);
            LottoResult lhs = new LottoResult(winningNumbers, bonusNumber);

            Function<List<Integer>, Lotto> mapper = numbers -> {
                List<LottoNumber> lottoNumbers = numbers.stream()
                        .map(LottoNumber::new).toList();
                return new Lotto(lottoNumbers);
            };

            return Stream.of(
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 6)), false),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 7)), true),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 7)), true),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 5, 8)), false),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 4, 7, 8)), true),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 3, 7, 8, 9)), true),
                    Arguments.of(lhs, mapper.apply(List.of(1, 2, 7, 8, 9, 10)), true),
                    Arguments.of(lhs, mapper.apply(List.of(1, 7, 8, 9, 10, 11)), true),
                    Arguments.of(lhs, mapper.apply(List.of(7, 8, 9, 10, 11, 12)), true));
        }

        @ParameterizedTest
        @MethodSource("generateShouldReturnCheckBonusArguments")
        void should_return_check_bonus(LottoResult lottoResult, Lotto lotto, boolean expected) {
            // when
            boolean checkBonus = lottoResult.checkBonus(lotto);

            // then
            assertThat(checkBonus).isEqualTo(expected);
        }
    }
}
