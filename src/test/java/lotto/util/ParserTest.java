package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("구입 금액은 숫자만 입력 가능")
    @Test
    void 구입_금액은_숫자만_입력_가능() {
        String input = "asdf";
        assertThatThrownBy(() -> Parser.parseStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("로또 번호는 ,와 숫자만 입력 가능")
    @Test
    void getLottoNumbers(){
        String input = "asdf";
        assertThatThrownBy(() -> Parser.parseStringToList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }
}