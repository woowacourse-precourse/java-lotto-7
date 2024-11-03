package lotto;

import lotto.input.BonusNumber;
import lotto.input.LottoPrice;
import lotto.input.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    @Test
    void 가격_입력_시_int형으로_잘_반환되어야_한다() {
        LottoPrice lottoPrice = new LottoPrice("3000");
        assertEquals(3000, lottoPrice.get());
    }

    @Test
    void 가격_입력_시_로또개수를_잘_반환되어야_한다() {
        LottoPrice lottoPrice = new LottoPrice("3000");
        assertEquals(3, lottoPrice.getLottoCount());
    }

    @Test
    void 보너스_번호_입력_시_int형으로_잘_변환되어야_한다() {
        BonusNumber bonusNumber = new BonusNumber("7");
        assertEquals(7, bonusNumber.get());
    }

    @Test
    void 당첨_번호_입력_시_리스트로_잘_변환되어야_한다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(winningNumbers.get(), numberList);
    }


}
