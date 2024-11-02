package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoCreateService 테스트")
public class LottoCreateServiceTest {

    private LottoCreateService lottoCreateService;

    @BeforeEach
    void setUp() {
        lottoCreateService = new LottoCreateService();
    }

    @Test
    void 랜덤번호_6개를_생성한다() {
        //when
        List<Integer> randomNumbers = lottoCreateService.createRandomNumbers();

        //then
        assertThat(randomNumbers).hasSize(6);
    }

    @Test
    void 랜덤로또_n개를_생성한다() {
        //given
        int lottoCount = 5;

        //when
        Lottos myLottos = lottoCreateService.createLottos(lottoCount);

        //then
        assertThat(myLottos.getLottos()).hasSize(lottoCount);
    }

    @Test
    void 가격만큼_로또를_생성한다(){
        //given
        int money = 14000;

        //when
        Lottos lottos = lottoCreateService.createLottosWithMoney(money);

        //then
        assertThat(lottos.getLottos()).hasSize(14);
    }

}
