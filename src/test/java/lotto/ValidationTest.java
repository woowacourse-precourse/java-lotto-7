package lotto;

import lotto.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.validation.ErrorMessage.LOTTO_ERROR_WRONG_LOTTO_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    private final Validation validation = new Validation();

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
            validation.checkLottoSize(lotto_numbers);
        });

        // then
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", throwable.getMessage());
    }
    


}