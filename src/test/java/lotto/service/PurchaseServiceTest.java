package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PurchaseServiceTest {
    private static PurchaseService purchaseService;
    private static LottoRepository lottoRepository;

    @BeforeEach
    void setup(){
        lottoRepository = new LottoRepositoryImpl(new ArrayList<>());
        purchaseService = new PurchaseService(lottoRepository);
    }

    @Test
    void 로또_구매_테스트(){
        // given
        purchaseService.purchase(new Money(8000));

        // when
        List<Lotto> lottos = lottoRepository.findAll();

        // then
        assertThat(lottos)
                .hasSize(8);

        assertThat(lottos.get(0).getNumbers())
                .hasSize(6)
                .anyMatch(n -> n >= 1 && n <= 45)
                .doesNotHaveDuplicates();
    }
}
