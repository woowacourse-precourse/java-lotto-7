package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class DrawLottoTest {
    @Test
    void 몰라_테스트() {
        assertThat(new DrawLotto("1,2,3,4,5,6", "7").getWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}