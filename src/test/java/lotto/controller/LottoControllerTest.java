package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    private final LottoController lottoController = new LottoController();

    @DisplayName("로또 구입 금액 1000원당 1장이 발행된다.")
    @Test
    void 로또_구입_금액_1000원당_1장이_발행된다() {
        assertEquals(3, lottoController.getLottoCount("3000"));
        assertEquals(10, lottoController.getLottoCount("10000"));
        assertEquals(2, lottoController.getLottoCount("2000"));
    }

    @DisplayName("로또 구입 금액에 문자열이 들어가면 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_문자열이_들어가면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            lottoController.getLottoCount("문자열");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            lottoController.getLottoCount("1500");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 6개여야 한다.")
    @Test
    void 당첨_번호는_6개여야_한다() {
        assertEquals(6
                , lottoController.getWinningNumber(new String[]{"1", "2", "3", "4", "5", "6"}).size());
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            lottoController.getWinningNumber(new String[]{"1","2","4","5"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 발생하면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복이_발생하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            lottoController.getWinningNumber(new String[]{"1","1","3","4","5","6"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

}