package lotto.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoInputTest {

    @Test
    void 범위_내의_숫자가_아닐때_예외처리() {

        //GIVEN
        LottoInput lottoInput = new LottoInput();

        //WHEN
        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoInput.numberParse("90");
        });

    }

    @Test
    void 숫자가_아닐때_예외처리() {
        //GIVEN
        LottoInput lottoInput = new LottoInput();

        //WHEN
        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            lottoInput.numberParse("q");
        });
    }

}
