package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import lotto.controller.MoneyCount;
import lotto.model.Lotto;
import lotto.controller.PurchasingInput;
import org.junit.jupiter.api.Test;

public class PurchasingInputTest {

    @BeforeEach
    void setUp() {
        // 테스트 전마다 기본 입력 스트림을 초기화
        System.setIn(System.in);
    }

    @Test
    void 제대로_된_값을_넣으면_잘_작동() {
        String input = "2000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer cost = PurchasingInput.getCost();
        assertEquals(2000, cost);
    }

//    @Test
//    void 잘못된_값을_넣으면_오작동_알파벳() {
//        String input = "2000a\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, PurchasingInput::getCost);
//        assertEquals("[ERROR] 올바른 숫자를 입력하세요", exception.getMessage());
//    }
    //따로따로 했을 때는 잘 동작하는데
}
