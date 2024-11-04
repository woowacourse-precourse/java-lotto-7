package lotto;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomLottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아닐경우 예외가 발생한다.")
    @Test
    void createLottoByInvalidSize() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoByInvalidRange(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, invalidNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("특정 번호가 포함되어 있는지 확인한다.")
    @Test
    void hasNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasNumber(1)).isTrue();
        assertThat(lotto.hasNumber(7)).isFalse();
    }

    @DisplayName("일치하는 번호 개수를 반환한다.")
    @Test
    void countMatchingNumbers() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto1.countMatchingNumbers(lotto2)).isEqualTo(3);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 있으면 예외가 발생한다")
    @Test
    void invalidWinningNumberFormat() {
        // given
        LottoGame game = new LottoGame();

        // Console.readLine() 결과를 순서대로 설정
        commandInput("1000",               // 구매 금액
                "1,2,3,a,5,6",        // 당첨 번호 (잘못된 입력)
                "7");                  // 보너스 번호

        // when & then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 형식의 당첨 번호가 아닙니다.");
    }

    @DisplayName("당첨 번호의 형식이 올바르지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3,,5,6",     // 빈 값
            "1,2,3,@,5,6",    // 특수문자
            "1 2 3 4 5 6",    // 쉼표 없음
            "abc",            // 문자열
            ""                // 빈 문자열
    })
    void invalidWinningNumberFormats(String input) {
        // given
        LottoGame game = new LottoGame();

        // Console.readLine() 결과를 순서대로 설정
        commandInput("1000",    // 구매 금액
                input,      // 당첨 번호 (잘못된 입력)
                "7");       // 보너스 번호

        // when & then
        assertThatThrownBy(() -> game.start())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바른 형식의 당첨 번호가 아닙니다.");
    }

    private void commandInput(String... inputs) {
        camp.nextstep.edu.missionutils.Console.close();
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));
    }
}