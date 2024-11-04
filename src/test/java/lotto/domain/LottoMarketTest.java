package lotto.domain;

import lotto.service.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoMarketTest {
    private LottoMarket lottoMarket;
    private LottoNumberGenerator lottoNumberGenerator;

    private static final int HAVE_MONEY = 5000;
    private static final int LOTTO_PRICE = 1000;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoMarket = new LottoMarket(new MockLottoFactory(lottoNumberGenerator));
    }

    @Test
    @DisplayName("sellLottos 메서드 테스트")
    void 금액만큼_로또를_구매하여_구매한_만큼의_로또가_반환되면_테스트_성공() {
        //given
        int expectedSize = HAVE_MONEY / LOTTO_PRICE;
        //when
        List<Lotto> lottos = lottoMarket.sellLottos(HAVE_MONEY);
        //then
        Assertions.assertThat(lottos)
                .hasSize(expectedSize)
                .allMatch(lotto -> lotto instanceof Lotto, "모든 lotto는 로또 객체여야 합니다.");

        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(numbers -> System.out.println("Mock Lotto numbers: " + numbers));
    }

    private static class MockLottoFactory extends LottoFactory {

        public MockLottoFactory(LottoNumberGenerator lottoNumberGenerator) {
            super(lottoNumberGenerator);
        }

        @Override
        public List<Lotto> createAllLottos(long quantity) {
            List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < quantity; i++) {
                lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 동일한 번호의 로또 객체 생성
            }
            return lottos;
        }
    }
}
