package lotto.domain;

import lotto.domain.provider.DefinedNumberProvider;
import lotto.domain.provider.NumberProvider;
import lotto.domain.validator.DefaultRangeValidator;
import lotto.domain.validator.RangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lotto lotto;
    private Draw draw;

    @BeforeEach
    void setUp() {
        NumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        RangeValidator rangeValidator = new DefaultRangeValidator();
        this.lotto = new Lotto(numberProvider, rangeValidator);

        this.draw = new Draw(lotto, 7, rangeValidator);
    }

    @DisplayName("로또 리스트를 통해 생성할 수 있다.")
    @Test
    void createLottosWithLottoList() {
        List<Lotto> lottoList = List.of(lotto, lotto, lotto);

        Lottos lottos = new Lottos(lottoList);

        assertThat(lottos.getLottos()).hasSize(3);
    }

    @DisplayName("3개의 로또 당첨 처리 시 3개의 등수를 반환한다.")
    @Test
    void return3RankListWith3LottoList() {
        List<Lotto> lottoList = List.of(lotto, lotto, lotto);
        Lottos lottos = new Lottos(lottoList);

        Ranks ranks = lottos.draw(draw);

        assertThat(ranks.count()).isEqualTo(3);
    }

}
