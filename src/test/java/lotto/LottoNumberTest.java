package lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.store.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또_숫자의_개수가_불일치하면_TRUE를_반환한다() {
        //given
        int count = 7;

        //when
        boolean actual = LottoNumber.isNotEqualCount(count);

        //then
        assertTrue(actual);
    }

    @Test
    void 로또_숫자의_개수가_일치하면_FAlSE를_반환한다() {
        //given
        int count = 6;

        //when
        boolean actual = LottoNumber.isNotEqualCount(count);

        //then
        assertFalse(actual);
    }

}
