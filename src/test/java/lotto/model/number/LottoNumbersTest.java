package lotto.model.number;

import lotto.mock.number_generator.RealRandomNumberGenerator;
import lotto.model.exception.LottoNumberInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoNumbers 테스트")
public class LottoNumbersTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final RealRandomNumberGenerator realRandomNumberGenerator = new RealRandomNumberGenerator();

    static Stream<Arguments> 로또_번호가_특정_크기인지_여부를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(LottoNumbers.generate(7, realRandomNumberGenerator), 7, true),
                Arguments.of(LottoNumbers.generate(6, realRandomNumberGenerator), 6, true),
                Arguments.of(LottoNumbers.generate(7, realRandomNumberGenerator), 6, false),
                Arguments.of(LottoNumbers.generate(8, realRandomNumberGenerator), 7, false)
        );
    }

    static Stream<Arguments> 자신의_로또_번호들의_중복_여부를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), true),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 2)), false),
                Arguments.of(makeLottoNumbers(List.of(1, 3, 3)), false)
        );
    }

    static LottoNumbers makeLottoNumbers(List<Integer> numbers) {
        return LottoNumbers.from(numbers.stream().map(LottoNumber::from).toList());
    }

    static Stream<Arguments> 특정_로또_번호를_포함하는지_여부를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), LottoNumber.from(3), true),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), LottoNumber.from(6), false),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), LottoNumber.from(1), true)
        );
    }

    static Stream<Arguments> 다른_로또_번호들과_일치하는_로또_번호의_개수를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(List.of(1, 2)), makeLottoNumbers(List.of(1, 2, 3)), 2),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3, 4)), makeLottoNumbers(List.of(1, 2, 9)), 2),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), makeLottoNumbers(List.of(1, 2, 3)), 3),
                Arguments.of(makeLottoNumbers(List.of(1, 2, 3)), makeLottoNumbers(List.of(4, 5, 6)), 0)
        );
    }

    public static List<LottoNumber> getLottoNumbers(LottoNumbers lottoNumbers) {
        try {
            Field field = LottoNumbers.class.getDeclaredField("lottoNumbers");
            field.setAccessible(true);

            @SuppressWarnings("unchecked")
            List<LottoNumber> filedValue = (List<LottoNumber>) field.get(lottoNumbers);

            return filedValue;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Lottos 객체의 lottos 필드 접근에 실패했습니다.");
        }
    }

    @Test
    void 생성_가능한_로또_번호_수를_초과하면_예외가_발생한다() {

        // given
        int size = MAX_NUMBER - MIN_NUMBER + 2;

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.generate(size, realRandomNumberGenerator))
                .isInstanceOf(LottoNumberInvalidException.class);
    }

    @ParameterizedTest(name = "numberCount: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 사이즈만큼의_로또_번호를_랜덤으로_생성한다(int numberCount) {

        // given
        int expected = numberCount;

        // when
        int actual = getLottoNumbers(LottoNumbers.generate(numberCount, realRandomNumberGenerator)).size();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "size: {0}")
    @ValueSource(ints = {11, 12, 13, 14, 15})
    void 로또_번호들을_정수로_변환한다(int size) {

        // given
        LottoNumbers lottoNumbers = LottoNumbers.generate(size, realRandomNumberGenerator);
        List<Integer> expected = realRandomNumberGenerator.getLastGeneratedNumbers();

        // when
        List<Integer> actual = lottoNumbers.mapToInt();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "lottoNumbers: {0}, size: {1}, expected: {2}")
    @MethodSource("로또_번호가_특정_크기인지_여부를_반환한다_테스트_케이스")
    void 로또_번호가_특정_크기인지_여부를_반환한다(LottoNumbers lottoNumbers, int size, boolean expected) {

        // when
        boolean actual = lottoNumbers.hasSize(size);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "lottoNumbers: {0}, expected: {1}")
    @MethodSource("자신의_로또_번호들의_중복_여부를_반환한다_테스트_케이스")
    void 자신의_로또_번호들의_중복_여부를_반환한다(LottoNumbers lottoNumbers, boolean expected) {

        // when
        boolean actual = lottoNumbers.hasUniqueElements();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "lottoNumbers: {0}, lottoNumber: {1}, expected: {2}")
    @MethodSource("특정_로또_번호를_포함하는지_여부를_반환한다_테스트_케이스")
    void 특정_로또_번호를_포함하는지_여부를_반환한다(LottoNumbers lottoNumbers, LottoNumber lottoNumber, boolean expected) {

        // when
        boolean actual = lottoNumbers.contains(lottoNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "lottoNumbers: {0}, other: {1}, expected: {2}")
    @MethodSource("다른_로또_번호들과_일치하는_로또_번호의_개수를_반환한다_테스트_케이스")
    void 다른_로또_번호들과_일치하는_로또_번호의_개수를_반환한다(LottoNumbers lottoNumbers, LottoNumbers other, int expected) {

        // when
        int actual = lottoNumbers.countMatch(other);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
