package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LottoValueUtilTest {

    @Test
    void 로또_구매_금액_테스트() {
        assertEquals(10000, LottoValueUtil.toLottoAmount("10000"));
        assertThatThrownBy(() -> LottoValueUtil.toLottoAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_중복인_경우_예외_발생(){
        assertThatThrownBy(()-> LottoValueUtil.toWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_6개가_아닌_경우_예외_발생(){
        assertThatThrownBy(()-> LottoValueUtil.toWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoValueUtil.toWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨_번호_범위를_벗어난_경우_예외_발생(){
        assertThatThrownBy(()-> LottoValueUtil.toWinningNumbers("1,2, 3,4 , 5,100"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoValueUtil.toWinningNumbers("0,1, 2,3, 4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_범위를_벗어난_경우_예외_발생(){
        assertThatThrownBy(()-> LottoValueUtil.toBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> LottoValueUtil.toBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_개수가_1개_이상일_경우_예외_발생(){
        assertThatThrownBy(()-> LottoValueUtil.toBonusNumber("1,2"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}