package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOManagerTest {
    @DisplayName("숫자가 아닌 값이 입력됐을때 예외가 발생한다.")
    @Test
    void moneyTest() {
        IOManager ioManager = new IOManager();
        assertThatThrownBy(() -> ioManager.integerParser("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또의 수가 생성된 로또수와 일치하지 않을떄 예외가 발생한다.")
    @Test
    void randomNumberPickTest() {
        IOManager ioManager = new IOManager();
        assertThatThrownBy(() -> ioManager.printNewLotto(2, List.of(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
