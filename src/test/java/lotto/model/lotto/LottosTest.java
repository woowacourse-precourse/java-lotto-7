package lotto.model.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("정확한 개수의 Lotto 객체를 생성해야 한다.")
    void shouldGenerateExactCount() {
        int count = 5;
        Lottos lottos = Lottos.generate(count);
        assertEquals(count, lottos.getLottos().size());
    }

    @Test
    @DisplayName("반환하는 Lottos는 불변이어야 한다.")
    void shouldReturnImmutableList() {
        Lottos lottos = Lottos.generate(3);
        assertThrows(UnsupportedOperationException.class, () -> {
            lottos.getLottos().add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        });
    }

}
