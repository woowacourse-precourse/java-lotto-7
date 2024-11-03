package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @ParameterizedTest
    @DisplayName("보너스 번호 범위초과 및 중복 예외 발생 테스트")
    @ValueSource(ints = {0, -1, 46})
    void 보너스_번호_예외_발생_테스트(int input) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto);

        assertThatThrownBy(() -> winningLotto.setBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 입력 범위 초과 예외 발생 테스트")
    @MethodSource("inputs")
    void 당첨_번호_입력_범위_초과_예외_발생_테스트(Lotto input) {
        assertThatThrownBy(() -> new WinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    static Stream<Lotto> inputs() {
        return Stream.of(new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)));
    }
}
