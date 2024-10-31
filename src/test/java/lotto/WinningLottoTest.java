package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨_로또_생성() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertThat(winningLotto).isEqualTo(new WinningLotto("1,2,3,4,5,6", "7"));
    }
}
