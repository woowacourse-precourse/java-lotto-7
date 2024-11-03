package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteryManagerTest {
    @DisplayName("로또 번호의 숫자들은 정렬된 상태로 저장되어야 한다.")
    @Test
    void 로또_번호의_숫자들은_정렬된_상태로_저장되어야_한다() {
        //given

        //when
        Lotto lotto = new Lotto(List.of(43, 8, 16, 2, 41, 23));

        //then
        assertThat(lotto.getNumbers()).isSorted();
    }
}