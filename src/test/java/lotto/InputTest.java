package lotto;

import lotto.model.bonusnumber.BonusNumber;
import lotto.model.lottoprice.LottoPrice;
import lotto.model.winningnumbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {

    @DisplayName("가격 입력 시 int형으로 잘 변환되어야 한다.")
    @Test
    void 가격_입력_시_int형으로_잘_변환되어야_한다() {
        LottoPrice lottoPrice = new LottoPrice("3000");
        assertEquals(3000, lottoPrice.get());
    }

    @DisplayName("가격 입력 시 로또개수를 잘 반환할 수 있어야 한다.")
    @Test
    void 가격_입력_시_로또개수를_잘_반환할_수_있어야_한다() {
        LottoPrice lottoPrice = new LottoPrice("3000");
        assertEquals(3, lottoPrice.getLottoCount());
    }

    @DisplayName("보너스 번호 입력 시 int형으로 잘 변환되어야 한다.")
    @Test
    void 보너스_번호_입력_시_int형으로_잘_변환되어야_한다() {
        BonusNumber bonusNumber = new BonusNumber("7");
        assertEquals(7, bonusNumber.get());
    }

    @DisplayName("당첨 번호 입력 시 리스트로 잘 변환되어야 한다.")

    @Test
    void 당첨_번호_입력_시_리스트로_잘_변환되어야_한다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(winningNumbers.get(), numberList);
    }
}
