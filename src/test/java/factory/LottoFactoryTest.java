package factory;

import static org.assertj.core.api.Assertions.assertThat;

import model.Lotto;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    void 로또_생성_테스트() {
        Lotto lotto = LottoFactory.make();

        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}


