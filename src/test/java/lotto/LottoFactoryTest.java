package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    void 입력된_횟수_만큼_로또_생성(){
        int input = 5;
        List<Lotto> lottos = LottoFactory.createLottos(input);

        Assertions.assertThat(lottos).hasSize(input);
    }
}
