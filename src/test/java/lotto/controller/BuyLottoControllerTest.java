package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyLottoControllerTest {

    @DisplayName("컨트롤러 객체가 정상적으로 생성되어야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "5000", "6000"})
    void 컨트롤러_객체가_정상_생성_되어야함(String inputVal) {
        assertDoesNotThrow(() -> {
            new BuyLottoController(inputVal);
        });
    }

    @DisplayName("컨트롤러 내부의 모델 객체의 문자열 포함 유효성 검사 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1000원", "2000A", "3000>", "4000$"})
    void 모델_객체_숫자_이외_값_예외_확인(String inputVal) {
        assertThatThrownBy(() -> {
            new BuyLottoController(inputVal);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 숫자만 입력해주세요.");
    }

    @DisplayName("입력한 금액이 천원 단위가 아니면 예외가 발생해야함")
    @ParameterizedTest
    @ValueSource(strings = {"4200", "1234", "999", "1001"})
    void 천원_단위가_아니면_예외_발생(String inputVal) {
        assertThatThrownBy(() -> {
            new BuyLottoController(inputVal);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잔돈이 없습니다. 1000원 단위에 맞춰 입력해주세요.");
    }
}