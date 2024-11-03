package lotto;

import static lotto.LottoConstant.*;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 5000})
    void 입력이_1000원_단위면_예외가_발생하지_않는다(long purchaseAmount) {
        //given
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validatePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(longs = {-1000, 0, 1500})
    void 입력이_1000원_단위가_아니면_예외가_발생한다(long purchaseAmount) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_UNIT.format(PRICE));
    }

    @Test
    void 유효한_범위의_중복이_없는_6개의_로또번호면_예외가_발생하지_않는다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,22,23,44,45);
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateWinningNumbers(winningNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또번호가_6개_보다_적으면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,23,44,45);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_COUNT_ERROR.format(NUMBER_COUNT));
    }

    @Test
    void 로또번호가_6개_보다_많으면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,3,22,23,44,45);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_COUNT_ERROR.format(NUMBER_COUNT));
    }

    @Test
    void 로또번호_범위보다_작은수가_있으면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(0,2,3,4,5,6);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_ERROR.format(MIN_VALUE, MAX_VALUE));
    }

    @Test
    void 로또번호_범위보다_큰수가_있으면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,46);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_ERROR.format(MIN_VALUE, MAX_VALUE));
    }

    @Test
    void 로또번호에_중복이_있으면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1,2,2,23,44,45);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER_ERROR.format());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 당첨번호와_중복되지_않는_범위안의_보너스번호면_예외가_발생하지_않는다(int bonusNumber) {
        //given
        List<Integer> winningNumbers = Arrays.asList(2, 3, 4, 5, 6, 7);
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateBonusNumber(bonusNumber, winningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨번호와_중복되는_보너스번호면_예외가_발생한다(int bonusNumber) {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.format());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void 범위밖의_보너스번호면_예외가_발생한다(int bonusNumber) {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_ERROR.format(MIN_VALUE, MAX_VALUE));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void 범위안의_숫자면_예외가_발생하지_않는다(int number) {
        //given
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateNumberRange(number, 1, 45))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void 범위밖의_숫자면_예외가_발생한다(int number) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateNumberRange(number, 1, 45))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_ERROR.format(1, 45));
    }

    @Test
    void 리스트에_중복이_없으면_예외가_발생하지_않는다() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateUniqueNumbers(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    void 리스트에_중복이_있으면_예외가_발생한다() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateUniqueNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER_ERROR.format());
    }

    @Test
    void 리스트크기와_개수가_같으면_예외가_발생하지_않는다() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int count = 6;
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateNumberCount(numbers, 6))
                .doesNotThrowAnyException();
    }

    @Test
    void 리스트크기와_개수가_다르면_예외가_발생한다() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int count = 6;
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateNumberCount(numbers, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_COUNT_ERROR.format(count));
    }

    @Test
    void 문자열의_길이가_1_이상이면_예외가_발생하지_않는다() {
        //given
        String input = "notEmptyString";
        //when
        //then
        Assertions.assertThatCode(()-> Validator.validateEmptyString(input))
                .doesNotThrowAnyException();

    }

    @ParameterizedTest
    @ValueSource(strings = {"\n","\t"," ",""})
    void 문자열이_공백이면_예외가_발생한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(()-> Validator.validateEmptyString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_STRING_ERROR.format());

    }
}