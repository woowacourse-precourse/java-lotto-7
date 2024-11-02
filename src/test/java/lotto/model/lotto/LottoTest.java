package lotto.model.lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    @DisplayName("Lotto는 원본 리스트의 변경에 영향을 받지 않는다.")
    void shouldNotAffectOriginalListChanged() {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(original);

        original.set(0, 99);
        assertNotEquals(99, lotto.getNumbers().getFirst());
    }

    @Test
    @DisplayName("Lotto 리스트는 불변이어야 한다.")
    void shouldReturnImmutableList() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(UnsupportedOperationException.class, () -> {
            lotto.getNumbers().add(7);
        });
    }

}
