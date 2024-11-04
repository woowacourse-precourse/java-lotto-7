package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 보너스_번호_범위_다른_숫자_테스트(){
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),47))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 보너스_번호_범위_중복_테스트(){
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
