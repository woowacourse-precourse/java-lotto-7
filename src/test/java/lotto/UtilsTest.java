package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    private final static Integer LOTTO_NUMBER_START = 1;
    private final static Integer LOTTO_NUMBER_END = 45;
    private final static Integer LOTTO_MAX_LENGTH = 6;

    @DisplayName("로또 번호 정렬")
    @Test
    void 로또번호_정렬() {
        //given
        List<Integer> lottoNumbers = randomLottoNumbers(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_MAX_LENGTH);

        //when
        List<Integer> sortLottoNumbers = sortLottoNumbers(lottoNumbers);

        //then
        for (int i = 0; i < sortLottoNumbers.size() - 1; i++) {
            assertTrue(sortLottoNumbers.get(i) < sortLottoNumbers.get(i + 1));
        }

    }

}