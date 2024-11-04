package lotto.exception;

import lotto.constants.ExceptionsMessageConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputExceptionTest {

    private InputViewException inputViewException;
    private static final List<Integer> parsedNumbers = List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void setUp() {
        inputViewException = new InputViewException();
    }

    @DisplayName("구입 금액의 타입과 범위 유효성 검증 기능 테스트")
    @Test
    void 구매_금액은_숫자여야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_MUST_BE_NUMERIC);
    }

    @DisplayName("구입 금액이 0보다 큰 양수인지 유효성 검증 기능 테스트")
    @Test
    void 구매_금액은_0보다_커야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputMoney("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_NUMBER_MUST_BE_POSITIVE);

        assertThatThrownBy(() -> inputViewException.validateInputMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_NUMBER_MUST_BE_POSITIVE);
    }

    @DisplayName("구입 금액은 1000의 배수인지 유효성 검증 기능")
    @Test
    void 구매_금액은_1000단위여야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.MONEY_MUST_BE_A_MULTIPLE_OF_THOUSAND);
    }

    @DisplayName("구입 금액의 맨 앞이 0으로 시작하는지 유효성 검증 기능 테스트")
    @Test
    void 구매_금액은_0으로_시작해서_안된다() {
        assertThatThrownBy(() -> inputViewException.validateInputMoney("001000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_NUMBER_CANNOT_START_WITH_ZERO);
    }

    @DisplayName("구입 금액에 공백이 존재하는지 유효성 검증 기능 테스트")
    @Test
    void 구매_금액은_공백이_존재하지_않아야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputMoney("1 000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_CONTAINS_WHITE_SPACE);
    }

    @DisplayName("로또 번호는 빈 문자열이거나 null값인지 유효성 검증 기능 테스트")
    @Test
    void 로또_번호는_null값이나_빈문자열이면_안된다() {
        assertThatThrownBy(() -> inputViewException.validateInputNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_CANNOT_BE_EMPTY_OR_NULL);

        assertThatThrownBy(() -> inputViewException.validateInputNumbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_CANNOT_BE_EMPTY_OR_NULL);
    }

    @DisplayName("입력값에 숫자와 콤마(,) 외의 문자가 들어있는지 유효성 검증 기능 테스트")
    @Test
    void 로또_번호는_숫자와_콤마_이외에_문자가_들어가서는_안된다() {
        assertThatThrownBy(() -> inputViewException.validateInputNumbers("1,2,3,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_CONTAINS_NUMBER_AND_COMMA_ONLY);
    }

    @DisplayName("당첨 번호 개수가 6개인지 유효성 검증 기능 테스트")
    @Test
    void 로또_번호는_6개여야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.LOTTO_NUMBERS_COUNT_MUST_BE_SIX);
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 숫자인지 유효성 검증 기능 테스트")
    @Test
    void 로또_번호는_1부터_45사이여야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputNumbers("1,2,3,4,5,50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_NUMBERS_MUST_BE_IN_ALLOWED_RANGE);
    }

    @DisplayName("당첨 번호가 중복되는지 유효성 검증 기능")
    @Test
    void 로또_번호는_중복되어서는_안된다() {
        assertThatThrownBy(() -> inputViewException.validateInputNumbers("1,2,3,4,5,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.NUMBERS_CANNOT_BE_DUPLICATED);
    }

    @DisplayName("보너스 번호가 Integer인지 유효성 검증 기능 테스트")
    @Test
    void 보너스_번호는_숫자여야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputBonusNumber("abc", parsedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_MUST_BE_NUMERIC);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자인지 유효성 검증 기능 테스트")
    @Test
    void 보너스_번호는_1부터_45_사이값이어야_한다_0일때() {
        assertThatThrownBy(() -> inputViewException.validateInputBonusNumber("0", parsedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_BONUS_NUMBER_MUST_BE_IN_ALLOWED_RANGE);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자인지 유효성 검증 기능 테스트")
    @Test
    void 보너스_번호는_1부터_45_사이값이어야_한다() {
        assertThatThrownBy(() -> inputViewException.validateInputBonusNumber("46", parsedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_BONUS_NUMBER_MUST_BE_IN_ALLOWED_RANGE);
    }

    @DisplayName("보너스 번호가 입력된 당첨 번호와 중복되는지 유효성 검증 기능 ")
    @Test
    void 보너스_번호는_중복되어서는_안된다() {
        assertThatThrownBy(() -> inputViewException.validateInputBonusNumber("5", parsedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionsMessageConstants.INPUT_BONUS_NUMBER_DUPLICATED);
    }
}
