package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 번호가_정렬됐는지_확인하다() {
        // given
        Lotto lotto = new Lotto(List.of(13, 2, 4, 26, 5, 9));

        // when

        // then
        assertEquals(List.of(2, 4, 5, 9, 13, 26), lotto.getNumbers());
    }
}