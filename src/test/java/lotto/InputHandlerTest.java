package lotto;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    private InputHandler inputHandler;
    private InputStream originalSystemIn; // 원래의 System.in 저장
    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn); // 모든 테스트 후 원래의 System.in으로 복원
    }
    @BeforeEach
    void setUp(){
        inputHandler = new InputHandler();
        originalSystemIn = System.in; // 원래의 System.in 저장
    }

    @Test
    void 정상적인_로또금액_입력(){
        assertThat(inputHandler.validateBuyAmount("1000")).isEqualTo(1000);
        assertThat(inputHandler.validateBuyAmount("2000")).isEqualTo(2000);

    }


    @Test
    void null값_로또금액_입력(){
        assertThatThrownBy(() ->  inputHandler.validateBuyAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }
    @Test
    void 천단위가_아닌_로또금액_입력(){
        assertThatThrownBy(() ->  inputHandler.validateBuyAmount("17"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @Test
    void 입력로또번호_정상() {
        assertThat(inputHandler.validateInputNumber("1,2,3,4,5,6")).isEqualTo(Arrays.asList(1,2,3,4,5,6));
        assertThat(inputHandler.validateInputNumber("1,2,3,14,23,45")).isEqualTo(Arrays.asList(1,2,3,14,23,45));
    }
    @Test
    void 입력로또번호_비정상() {
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위를 확인 해 주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위를 확인 해 주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber(" , , , , , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber(",,1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber(",,1,2,3,,,4,5,,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber(",,1,2,3,,,4,5,,,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5,;"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateInputNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }
    @Test
    void 보너스_번호(){
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputHandler.getInputNumber();
        assertThat(inputHandler.validateBonusNumber("7")).isEqualTo(7);
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }
    @Test
    void 보너스_번호_정상_x(){
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위를 확인 해 주세요.");
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위를 확인 해 주세요.");
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
        assertThatThrownBy(() ->  inputHandler.validateBonusNumber("3.3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }
}