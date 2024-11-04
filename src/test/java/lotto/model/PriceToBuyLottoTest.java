package lotto.model;

import lotto.exception.PriceToBuyLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceToBuyLottoTest {

    @DisplayName("로또 가격 객체가 성공적으로 생성된다")
    @Test
    void 로또_가격_객체_생성_성공() {
        //given
        String price = "5000";
        //when
        PriceToBuyLotto priceToBuyLotto = PriceToBuyLotto.of(price);
        //then
        assertEquals(priceToBuyLotto.price(), 5000);
    }

    @DisplayName("로또 가격 객체가 성공적으로 생성된다. 가격 문자열에 공백이 있어도 성공")
    @Test
    void 로또_가격_객체_생성_성공_문자열_공백() {
        //given
        String price = " 5000 ";
        //when
        PriceToBuyLotto priceToBuyLotto = PriceToBuyLotto.of(price);
        //then
        assertEquals(priceToBuyLotto.price(), 5000);
    }

    @DisplayName("로또 가격이 음수일 때 실패")
    @Test
    void 로또_가격_객체_생성_실패_음수() {
        //given
        String price = "-5000";
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLotto.of(price);
        });
    }

    @DisplayName("로또 가격이 실수일 때 실패")
    @Test
    void 로또_가격_객체_생성_실패_실수() {
        //given
        String price = "5000.1";
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLotto.of(price);
        });
    }

    @DisplayName("로또 가격이 1000단위가 아닐 때 실패")
    @Test
    void 로또_가격_객체_생성_실패_단위() {
        //given
        String price = "5200";
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLotto.of(price);
        });
    }

    @DisplayName("로또 가격이 2,000,000,000 넘을 때 실패")
    @Test
    void 로또_가격_객체_생성_실패_범위_초과() {
        //given
        String price = "2000001000";
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLotto.of(price);
        });
    }
}
