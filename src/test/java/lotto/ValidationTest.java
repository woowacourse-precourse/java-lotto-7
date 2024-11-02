package lotto;

import lotto.util.Utils;
import lotto.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.validation.ErrorMessage.LOTTO_ERROR_WRONG_LOTTO_SIZE;
import static lotto.validation.Validation.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    private static final Integer LOTTO_START_NUMBER = 1;
    private static final Integer LOTTO_END_NUMBER = 45;
    private static final Integer LOTTO_MAX_LENGTH = 6;
    private List<Integer> lotto_numbers;
    @BeforeEach
    void 로또_번호_추첨() {
        lotto_numbers = new ArrayList<>();
    }

    @DisplayName("로또 번호가 6개 초과 오류 메시지 출력")
    @Test
    void 로또_입력값이_6을_초과() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH + 1);

        // when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkLottoSize(lotto_numbers, LOTTO_MAX_LENGTH));

        // then
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", throwable.getMessage());
    }

    @DisplayName("로또 번호가 6개 미만 오류 메시지 출력")
    @Test
    void 로또_입력값이_6미만() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH - 1);

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkLottoSize(lotto_numbers, LOTTO_MAX_LENGTH));

        //then
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", throwable.getMessage());
    }

    @DisplayName("로또 번호 중복 체크")
    @Test
    void 로또_번호값_중복_체크() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH);
        lotto_numbers.addAll(lotto_numbers);

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkLottoDuplicate(lotto_numbers));

        //then
        assertEquals("[ERROR] 로또 번호가 중복됩니다.", throwable.getMessage());
    }

    @DisplayName("로또 번호 범위 유효성 체크")
    @Test
    void 로또_번호가_유효한지_확인() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH - 1);
        lotto_numbers.add(46);

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkLottoNumberRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, lotto_numbers));

        //then
        assertEquals("[ERROR] 로또 번호는 1 ~ 45 사이 번호입니다.", throwable.getMessage());
    }

    @DisplayName("로또 보너스 번호 중복 체크")
    @Test
    void 로또_보너스_입력값이_중복_체크() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH);
        Integer first_number = lotto_numbers.get(0);

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkDuplicateBonusNumber(lotto_numbers, first_number));

        //then
        assertEquals("[ERROR] 로또 번호가 중복됩니다.", throwable.getMessage());
    }

    @DisplayName("로또 당첨 번호 입력 정상")
    @Test
    void 로또_당첨번호_정상입력() {
        //given
        String lottoPrizeNumber = "1,2,3,4,5,6";

        //when //then
        assertDoesNotThrow(() ->
                checkInputTypeNumbers(lottoPrizeNumber));
    }

    @DisplayName("로또 당청 번호 문자 입력 오류")
    @Test
    void 로또_당첨번호_문자입력() {
        //given
        String lottoPrizeNumber = "1,2,3,4,5,a";

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkInputTypeNumbers(lottoPrizeNumber));

        //then
        assertEquals("[ERROR] 숫자를 입력해주세요.", throwable.getMessage());
    }

}