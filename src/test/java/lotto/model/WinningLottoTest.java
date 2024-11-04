package lotto.model;

import lotto.mock.number_generator.ChoosableRandomNumberMaker;
import lotto.mock.number_generator.DuplicateRandomNumberGenerator;
import lotto.mock.number_generator.SequentialRandomNumberGenerator;
import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("WinningLotto 테스트")
public class WinningLottoTest {

    private final int WINNING_LOTTO_NUMBER_SIZE = 6;
    private final SequentialRandomNumberGenerator sequentialRandomNumberGenerator = new SequentialRandomNumberGenerator();
    private final DuplicateRandomNumberGenerator duplicateRandomNumberGenerator = new DuplicateRandomNumberGenerator();

    private static WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        LottoNumbers winningNumbers = LottoNumbers.from(lottoNumbers);

        return new WinningLotto(winningNumbers, LottoNumber.from(bonusNumber));
    }

    static Stream<Arguments> 로또와_비교해_일치하는_번호의_개수를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 8), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 14, 15, 17), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 8, 9), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(11, 12, 13, 14, 15, 10), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 12, 13, 14, 15, 17), 1)
        );
    }

    static Stream<Arguments> 보너스_번호가_일치하는지_확인한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6), false),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 7), true)
        );
    }

    @Test
    void 당첨_로또_번호의_개수가_기준치를_넘어가면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(WINNING_LOTTO_NUMBER_SIZE + 1);

        LottoNumbers winningLottoNumbers = LottoNumbers.generateBy(WINNING_LOTTO_NUMBER_SIZE + 1,
                sequentialRandomNumberGenerator);

        LottoNumber bonusNumber = LottoNumber.from(WINNING_LOTTO_NUMBER_SIZE + 2);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_로또_번호의_개수가_기준치보다_작으면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(WINNING_LOTTO_NUMBER_SIZE - 1);

        LottoNumbers winningLottoNumbers = LottoNumbers.generateBy(WINNING_LOTTO_NUMBER_SIZE - 1,
                sequentialRandomNumberGenerator);

        LottoNumber bonusNumber = LottoNumber.from(WINNING_LOTTO_NUMBER_SIZE);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(WINNING_LOTTO_NUMBER_SIZE);

        LottoNumbers winningLottoNumbers = LottoNumbers.generateBy(WINNING_LOTTO_NUMBER_SIZE,
                duplicateRandomNumberGenerator);
        LottoNumber bonusNumber = LottoNumber.from(WINNING_LOTTO_NUMBER_SIZE + 1);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호에_포함되면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(WINNING_LOTTO_NUMBER_SIZE);

        LottoNumbers winningLottoNumbers = LottoNumbers.generateBy(WINNING_LOTTO_NUMBER_SIZE,
                sequentialRandomNumberGenerator);
        LottoNumber bonusNumber = LottoNumber.from(sequentialRandomNumberGenerator.getLastGeneratedNumbers().getFirst());

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "winningLottoNumbers: {0}, bonusNumber: {1}, lottoNumbers: {2}, expected: {3}")
    @MethodSource("로또와_비교해_일치하는_번호의_개수를_반환한다_테스트_케이스")
    void 로또와_비교해_일치하는_번호의_개수를_반환한다(List<Integer> winningLottoNumbers, int bonusNumber,
                                   List<Integer> lottoNumbers, int expected) {
        // given
        WinningLotto winningLotto = createWinningLotto(winningLottoNumbers, bonusNumber);

        Lotto lotto = Lotto.generateBy(new ChoosableRandomNumberMaker(lottoNumbers));

        // when
        int actual = winningLotto.getMatchCount(lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "winningLottoNumbers: {0}, bonusNumber: {1}, lottoNumbers: {2}, expected: {3}")
    @MethodSource("보너스_번호가_일치하는지_확인한다_테스트_케이스")
    void 보너스_번호가_일치하는지_확인한다(List<Integer> winningLottoNumbers, int bonusNumber,
                            List<Integer> lottoNumbers, boolean expected) {
        // given
        WinningLotto winningLotto = createWinningLotto(winningLottoNumbers, bonusNumber);

        Lotto lotto = Lotto.generateBy(new ChoosableRandomNumberMaker(lottoNumbers));

        // when
        boolean actual = winningLotto.isBonusNumberMatches(lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
