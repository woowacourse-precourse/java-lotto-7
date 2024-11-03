package lotto.service;

import lotto.Exception.LottoException;
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

    @ParameterizedTest
    @DisplayName("당첨번호와 보너스번호 중복 확인 기능 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validateNoDuplicates(int bonusNumber) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
            lottoService.validateNoDuplicates(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 보너스번호는 당첨번호 6개와 중복될 수 없습니다." , exception.getMessage());
    }
}