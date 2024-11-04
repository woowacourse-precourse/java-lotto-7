package lotto.view.response;

import lotto.mock.number_generator.RealRandomNumberGenerator;
import lotto.model.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoNumberResponse 테스트")
public class LottoNumberResponseTest {

    private static final RealRandomNumberGenerator realRandomNumberGenerator = new RealRandomNumberGenerator();

    static Stream<Arguments> 로또_번호_일급_컬렉션_객체로부터_생성된다_테스트_케이스() {
        return Stream.of(
                Arguments.of(
                        LottoNumbers.generateBy(3, realRandomNumberGenerator),
                        realRandomNumberGenerator.getLastGeneratedNumbers()
                ),

                Arguments.of(
                        LottoNumbers.generateBy(6, realRandomNumberGenerator),
                        realRandomNumberGenerator.getLastGeneratedNumbers()
                ),

                Arguments.of(
                        LottoNumbers.generateBy(7, realRandomNumberGenerator),
                        realRandomNumberGenerator.getLastGeneratedNumbers()
                )
        );
    }

    @ParameterizedTest(name = "lottoNumbers: {0}, expected: {1}")
    @MethodSource("로또_번호_일급_컬렉션_객체로부터_생성된다_테스트_케이스")
    void 로또_번호_일급_컬렉션_객체로부터_생성된다(LottoNumbers lottoNumbers, List<Integer> expected) {

        // when
        List<Integer> actual = LottoNumberResponse.from(lottoNumbers).getLottoNumbers();

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
