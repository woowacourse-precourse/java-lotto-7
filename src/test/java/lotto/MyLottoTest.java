package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {
    @Test
    void 로또_구입_개수에_해당하는_만큼_로또_발행() {
        MyLotto myLotto = new MyLotto(8);
        assertThat(myLotto.getCount()).isEqualTo(8);
    }
}
