package lotto;

import lotto.util.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.Validation.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_MAX_LENGTH = 6;
    private static final int MIN_COST = 1000;
    private static final int MAX_COST = 100000;
    private List<Integer> lotto_numbers;
    @BeforeEach
    void 로또_번호_추첨() {
        lotto_numbers = new ArrayList<>();
    }

    @DisplayName("로또 번호가 정상적으로 숫자로 입력되었는지 확인")
    @Test
    void 로또_입력값이_숫자인지() {
        //given
        String number = "12";

        //when & then
        assertDoesNotThrow(() ->
                checkInputTypeNumber(number));
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우")
    @Test
    void 로또_입력값이_숫자가_아닌경우() {
        //given
        String notNumber = "error";

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkInputTypeNumber(notNumber));

        //then
        assertEquals("[ERROR] 숫자를 입력해주세요.", throwable.getMessage());
    }

    @DisplayName("로또 번호들이 정상적으로 숫자로 입력되었는지 확인")
    @Test
    void 로또_입력값들이_숫자들인지() {
        //given
        String numbers = "12,34,45";

        //when & then
        assertDoesNotThrow(() ->
                checkInputTypeNumbers(numbers));
    }

    @DisplayName("로또 번호들이 숫자가 아닌 값이 있는 경우")
    @Test
    void 로또_입력값이_문자가_있는경우() {
        //given
        String numbers = "12,34,ss";

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkInputTypeNumbers(numbers));

        //when
        assertEquals("[ERROR] 숫자를 입력해주세요.", throwable.getMessage());
    }

    @DisplayName("로또 번호가 6개가 있는 경우")
    @Test
    void 로또_입력값이_6개() {
        //given
        lotto_numbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH);

        //when & then
        assertDoesNotThrow(() ->
                checkLottoSize(lotto_numbers, LOTTO_MAX_LENGTH));
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

    @DisplayName("로또 구매 최소 비용 오류")
    @Test
    void 로또_구매_최소비용_오류() {
        //given
        int money = 900;

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkMoneyMinCost(money, MIN_COST));

        //then
        assertEquals("[ERROR] 로또 구매 금액은 1000원 이상이여야 합니다.", throwable.getMessage());
    }

    @DisplayName("로또 구매 최대 비용 오류")
    @Test
    void 로또_구매_최대비용_오류() {
        //given
        int money = 101000;

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () ->
                checkMoneyMaxCost(money, MAX_COST));

        //then
        assertEquals("[ERROR] 로또 구매 금액은 1인당 10만원 이하로 구매 가능합니다.", throwable.getMessage());

    }

}