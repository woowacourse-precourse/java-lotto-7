package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.vo.Money;
import lotto.repository.InMemoryLottoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {
    LottoServiceImpl lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl(InMemoryLottoRepository.getInstance());
    }

    @AfterEach
    void cleanUp() {
        InMemoryLottoRepository.getInstance().clear();
    }

    @Test
    void 로또_구매_테스트() {
        //given
        Money money = new Money(2000);

        //when
        List<Lotto> lottos = lottoService.buyLotto(money);

        //then
        assertThat(lottos.size())
                .isEqualTo(2);
    }
}
