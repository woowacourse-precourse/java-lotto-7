package lotto.util;

import lotto.domain.CustomLotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("금액 입력 유효성 테스트 - 유효 금액")
    void validBudgetInputTest(){
        String testBudget = "17000";

        Validator validator = new Validator();

        assertDoesNotThrow(()->{validator.validateBudget(testBudget);});
    }

    @Test
    @DisplayName("금액 입력 유효성 테스트 - 1000원으로 나누어지지 않는 금액")
    void invalidBudgetInputTest(){
        String testBudget = "17100";

        Validator validator = new Validator();

        assertThrows(IllegalArgumentException.class, () ->{
            validator.validateBudget(testBudget);
        });
    }

    @Test
    @DisplayName("금액 입력 유효성 테스트 - 빈 문자열일때")
    void inputNumberIsBlankTest(){
        String testBudget = "   ";

        Validator validator = new Validator();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBudget(testBudget);
        });
        assertThat(illegalArgumentException.getMessage()).isEqualTo(ERROR_PREFIX.getErrorMessage()+INVALID_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("금액 입력 유효성 테스트 - 0원일때")
    void inputNumberIsZeroTest(){
        String testBudget = "0";

        Validator validator = new Validator();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBudget(testBudget);
        });
        assertThat(illegalArgumentException.getMessage()).isEqualTo(ERROR_PREFIX.getErrorMessage()+ZERO_BUDGET_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("금액 입력 유효성 테스트 - 문자열 입력이 이뤄지지 않았을 때")
    void notInputBudgetTest(){
        String testBudget="";
        Validator validator = new Validator();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBudget(testBudget);
        });
        assertThat(illegalArgumentException.getMessage()).isEqualTo(ERROR_PREFIX.getErrorMessage()+EMPTY_INPUT_VALUE_ERROR.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    void duplicateLottoNumbersTest(){
        String lottoNumbers = "1,2,3,3,4,5";
        Integer bonus = 10;
        Validator validator= new Validator();
        validator.validateLottoNumbers(lottoNumbers);

        //when
        LottoService lottoService = new LottoService();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            lottoService.makeCustomLotto(lottoNumbers, bonus);
        });

        assertThat(illegalArgumentException.getMessage()).isEqualTo(ERROR_PREFIX.getErrorMessage()+DUPLICATE_LOTTO_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호 중복 테스트")
    void duplicateLottoNumbersAndBonusTest(){
        String lottoNumbers = "1,2,3,29,4,5";
        Integer bonus = 29;
        Validator validator= new Validator();
        validator.validateLottoNumbers(lottoNumbers);

        //when
        LottoService lottoService = new LottoService();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            lottoService.makeCustomLotto(lottoNumbers, bonus);
        });

        assertThat(illegalArgumentException.getMessage()).isEqualTo(ERROR_PREFIX.getErrorMessage()+DUPLICATE_LOTTO_NUMBER.getErrorMessage());
    }


}