package lotto;

import lotto.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.validation.ErrorMessage.LOTTO_ERROR_WRONG_LOTTO_SIZE;
import static lotto.validation.Validation.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    private static final Integer LOTTO_MAX_LENGTH = 6;
    @DisplayName("로또 6개 이상 오류 메시지 출력")
    @Test
    void 로또_입력값이_6을_초과() {
        //given
        List<Integer> lotto_numbers = new ArrayList<>();

        for (int i = 1; i <= 7; i++) {
            lotto_numbers.add(i);
        }

        // when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            checkLottoSize(lotto_numbers, LOTTO_MAX_LENGTH);
        });

        // then
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", throwable.getMessage());
    }

    @DisplayName("로또 번호 중복 체크")
    @Test
    void 로또_번호값_중복_체크() {
        //given
        List<Integer> lotto_numbers = new ArrayList<>();

        lotto_numbers.add(1);
        for (int i = 1; i < 6; i++) {
            lotto_numbers.add(i);
        }

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            checkLottoDuplicate(lotto_numbers);
        });

        //then
        assertEquals("[ERROR] 로또 번호가 중복됩니다.", throwable.getMessage());
    }

    @DisplayName("로또 보너스 번호 중복 체크")
    @Test
    void 로또_보너스_입력값이_중복_체크() {
        //given
        List<Integer> lotto_numbers = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            lotto_numbers.add(i);
        }

        //when
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            checkDuplicateBonusNumber(lotto_numbers, 1);
        });

        //then
        assertEquals("[ERROR] 로또 번호가 중복됩니다.", throwable.getMessage());
    }


}