package lotto;

import lotto.util.ParseUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    @DisplayName("구매 금액 파싱 성공 테스트")
    @Test
    void 구매_금액_파싱_성공_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThat(parseUtil.parsePurchaseAmount("8000")).isEqualTo(8000);
    }

    @DisplayName("구매 금액 문자 입력 예외 테스트")
    @Test
    void 구매_금액_문자_입력_예외_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThrows(IllegalArgumentException.class, () -> parseUtil.parsePurchaseAmount("abc"));
    }

    @DisplayName("구매 금액 1000원 단위 아닐 경우 예외 테스트")
    @Test
    void 구매_금액_입력_단위_예외_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThrows(IllegalArgumentException.class, () -> parseUtil.parsePurchaseAmount("7777"));
    }

    @DisplayName("당첨 번호 파싱 테스트")
    @Test
    void 당첨_번호_파싱_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThat(parseUtil.parseWinningNumbers("1,2,3,4,5,6")).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호 문자 입력 예외 테스트")
    @Test
    void 당첨_번호_문자_입력_예외_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThrows(IllegalArgumentException.class, () -> parseUtil.parseWinningNumbers("a,2,3,4,5,6"));
    }

    @DisplayName("보너스 번호 파싱 테스트")
    @Test
    void 보너스_번호_파싱_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThat(parseUtil.parseBonusNumber("7", List.of(1, 2, 3, 4, 5, 6))).isEqualTo(7);
    }

    @DisplayName("보너스 번호 문자 입력 예외 테스트")
    @Test
    void 보너스_번호_문자_입력_예외_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThrows(IllegalArgumentException.class, () -> parseUtil.parseBonusNumber("b", List.of(1,2,3,4,5,6)));
    }

    @DisplayName("보너스 번호 당첨 번호 중복 예외 예외 테스트")
    @Test
    void 보너스_번호_당첨_번호_중복_예외_테스트() {
        ParseUtil parseUtil = new ParseUtil();
        assertThrows(IllegalArgumentException.class, () -> parseUtil.parseBonusNumber("1", List.of(1,2,3,4,5,6)));
    }

}
