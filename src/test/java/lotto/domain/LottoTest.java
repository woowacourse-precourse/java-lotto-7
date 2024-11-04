package lotto.domain;

import lotto.domain.lottoForm.Lotto;
import lotto.domain.lottoForm.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.LottoValues.SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 숫자가 6개 미만이면 예외가 발생한다.")
    @Test
    void lottoSizeTest() {
        // given
        List<Integer> numbers = List.of(12, 5, 7, 8, 1);

        // when & then
        assertThatCode(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_ERROR.getMessage());

    }

    @DisplayName("로또에 저장되는 6개의 숫자가 중복되면 예외가 발생한다")
    @Test
    void duplicateTest() {
        // given
        List<Integer> numbers = List.of(12, 12, 12, 4, 6, 8);

        // when & then
        assertThatCode(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("로또에 저장되는 6개의 숫자는 오름차순으로 저장된다.")
    @Test
    void lottoSortTest() {
        // given
        List<Integer> numbers = List.of(31, 12, 1, 7, 45, 26);

        // when
        Lotto lotto = Lotto.from(numbers);
        List<LottoNumber> lottoLottoNumbers = lotto.getNumbers();
        System.out.println(lottoLottoNumbers);

        // then
        for (int i = 0; i < SIZE.value() - 1; i++) {
            assertThat(lottoLottoNumbers.get(i).number()).isLessThan(lottoLottoNumbers.get(i + 1).number());
        }
    }

    @DisplayName("당첨번호와 일치하는 로또 번호들의 개수를 정확히 반환한다")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', '6,7,8,9,10,21', 1",
            "'11,12,13,14,15,45', '13,14,15,16,12,17', 4",
            "'5,10,1,35,20,25', '30,37,40,39,45,11', 0"
    })
    void matchingNumbersSuccessTest(String lottoInput, String winningInput, int expected) {
        // given
        List<Integer> numbers = Arrays.stream(lottoInput.split(","))
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = Lotto.from(numbers);
        WinningNumbers winningNumbers = WinningNumbers.from(winningInput);

        // when
        int matchingNumbers = lotto.getMatchingNumbers(winningNumbers);

        // then
        assertThat(matchingNumbers).isEqualTo(expected);
    }

    @DisplayName("보너스 번호가 포함되어있는지 여부를 성공적으로 반환한다")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', 1, true",
            "'11,12,13,14,15,45', 4, false",
            "'5,10,1,35,20,25', 44, false"
    })
    void bonusNumberSuccessTest(String lottoInput, int bonusInput, boolean expected) {
        // given
        List<Integer> numbers = Arrays.stream(lottoInput.split(","))
                .map(Integer::parseInt)
                .toList();
        LottoNumber bonusNumber = new LottoNumber(bonusInput);
        Lotto lotto = Lotto.from(numbers);

        // when
        boolean bonus = lotto.hasBonusNumber(bonusNumber);

        // then
        assertThat(bonus).isEqualTo(expected);
    }

}
