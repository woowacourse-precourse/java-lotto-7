package lotto.service;

import lotto.Exception.MoneyException;
import lotto.model.Lotto;
import lotto.utils.LottoRules;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private static final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발행하기")
    void lottoGenerate() {
        Assertions.assertThat(lottoService.generateLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @DisplayName("구매 금액 만큼 로또 발행하기")
    @ValueSource(ints = {1, 30, 20, 15, 4})
    void purchaseLottoTickets(int count) {
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(LottoRules.LOTTO_PRICE * count);
        assertEquals(lottoTickets.size(), count);
    }
}