package lotto.view;

import lotto.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력 된 String 타입의 돈이 숫자가 아닌 경우 예외 발생.")
    @Test
    void parseMoneyTest() {
        // given
        String money = "유준혁킹왕짱";
        // when // then
        assertThatThrownBy(() -> inputValidator.parseMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.MONEY_TYPE_ERROR.getMessage());
    }

    @DisplayName("입력 된 돈이 로또 가격보다 작은 경우 예외 발생.")
    @Test
    void validMoneyTest_lottoMinPrice() {
        // given
        Long money = 900L;
        // when // then
        assertThatThrownBy(() -> inputValidator.validMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_MIN_PRICE_ERROR.getMessage());
    }

    @DisplayName("입력 된 돈이 천원 단위가 아닌 경우 예외 발생.")
    @Test
    void validMoneyTest_lottoPriceUnit() {
        // given
        Long money = 1001L;
        // when // then
        assertThatThrownBy(() -> inputValidator.validMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_PRICE_ERROR.getMessage());
    }

    @DisplayName("입력 된 String 타입의 로또 당첨 번호가 숫자가 아닌 경우 예외 발생.")
    @Test
    void parseNumbersTest_notNumber() {
        // given
        String numbers = "1,2,3,4,5,유준혁킹왕짱";
        // when // then
        assertThatThrownBy(() -> inputValidator.parseNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.WINNING_NUMBER_TYPE_ERROR.getMessage());
    }

    @DisplayName("입력 된 String 타입의 로또 당첨 번호에 공백이 있는 경우 예외 발생.")
    @Test
    void parseNumbersTest_blank() {
        // given
        String numbers = "1, 2, 3, 4, 5, 6";
        // when // then
        assertThatThrownBy(() -> inputValidator.parseNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.WINNING_NUMBER_TYPE_ERROR.getMessage());
    }

    @DisplayName("입력 된 로또 당첨 번호의 개수가 6개가 아닌 경우 예외 발생.")
    @Test
    void validWinningNumberTest_lottoNumberCount() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // when // then
        assertThatThrownBy(() -> inputValidator.validWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("입력 된 로또 당첨 번호가 1부터 45사이가 아닌 경우 예외 발생.")
    @Test
    void validWinningNumberTest_lottoNumberRange() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        // when // then
        assertThatThrownBy(() -> inputValidator.validWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("입력 된 로또 당첨 번호에 중복된 숫자가 있는 경우 예외 발생.")
    @Test
    void validWinningNumberTest_lottoNumberDuplicate() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        // when // then
        assertThatThrownBy(() -> inputValidator.validWinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @DisplayName("입력 된 String 타입의 보너스 번호가 숫자가 아닌 경우 예외 발생.")
    @Test
    void parseBonusNumberTest() {
        // given
        String bonusNumber = "유준혁킹왕짱";
        // when // then
        assertThatThrownBy(() -> inputValidator.parseBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.BONUS_NUMBER_TYPE_ERROR.getMessage());
    }

    @DisplayName("입력 된 보너스 번호가 1부터 45사이가 아닌 경우 예외 발생.")
    @Test
    void validBonusNumberTest() {
        // given
        Integer bonusNumber = 46;
        // when // then
        assertThatThrownBy(() -> inputValidator.validBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }
}
