package lotto.domain;

import lotto.domain.provider.DefinedNumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 리스트를 통해 생성할 수 있다.")
    @Test
    void createLottosWithLottoList() {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        DefaultRangeValidator rangeValidator = new DefaultRangeValidator();
        List<Lotto> lottoList = List.of(
                new Lotto(numberProvider, rangeValidator),
                new Lotto(numberProvider, rangeValidator),
                new Lotto(numberProvider, rangeValidator)
        );

        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos.count()).isEqualTo(3);
    }

}
