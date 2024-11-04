package lotto.model;

import lotto.mock.number_generator.DuplicateRandomNumberGenerator;
import lotto.mock.number_generator.SequentialRandomNumberGenerator;
import lotto.model.exception.LottoNumberInvalidException;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 테스트")
class LottoTest {

    private final int LOTTO_NUMBER_SIZE = 6;
    private final DuplicateRandomNumberGenerator duplicateRandomNumberGenerator =
            new DuplicateRandomNumberGenerator();
    private final SequentialRandomNumberGenerator sequentialRandomNumberGenerator =
            new SequentialRandomNumberGenerator();

    @Test
    void 로또_번호의_개수가_기준치를_넘어가면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(LOTTO_NUMBER_SIZE + 1);

        // when & then
        assertThatThrownBy(() -> Lotto.generateBy(sequentialRandomNumberGenerator))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_기준치보다_작으면_예외가_발생한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(LOTTO_NUMBER_SIZE - 1);

        // when & then
        assertThatThrownBy(() -> Lotto.generateBy(sequentialRandomNumberGenerator))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {

        // when & then
        assertThatThrownBy(() -> Lotto.generateBy(duplicateRandomNumberGenerator))
                .isInstanceOf(LottoNumberInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_반환한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(LOTTO_NUMBER_SIZE);
        Lotto lotto = Lotto.generateBy(sequentialRandomNumberGenerator);

        // when
        LottoNumbers actual = lotto.getLottoNumbers();
        LottoNumbers expected = LottoNumbers.generateBy(LOTTO_NUMBER_SIZE, sequentialRandomNumberGenerator);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로또_번호_포함_여부를_확인한다() {

        // given
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(LOTTO_NUMBER_SIZE);

        // when
        Lotto lotto = Lotto.generateBy(sequentialRandomNumberGenerator);
        List<LottoNumber> generatedLottoNumbers = sequentialRandomNumberGenerator.getLastGeneratedNumbers().stream()
                .map(LottoNumber::from).toList();

        // then
        for (LottoNumber number : generatedLottoNumbers) {
            assertThat(lotto.containsLottoNumber(number)).isTrue();
        }
    }
}
