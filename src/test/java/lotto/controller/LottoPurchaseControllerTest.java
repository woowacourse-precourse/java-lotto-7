package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoPurchaseControllerTest {

    @DisplayName("생성 시 Null 값이 들어가면 유효성 검사에 걸려야한다.")
    @Test
    void 생성시_NULL_값이_들어가면_유효성_검사에_걸려야한다() {
        assertThatThrownBy(() -> new LottoPurchaseController(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 개수가 0개입니다.");
    }


    @DisplayName("생성시 로또 구매개수와 생성된 로또의 개수가 일치해야함")
    @Test
    void 생성시_로또_구매개수와_생성된_로또의_개수가_일치해야함() {
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(8);
        assertThat(lottoPurchaseController.getBuyLottoInfoList().size()).isSameAs(8);
    }
}