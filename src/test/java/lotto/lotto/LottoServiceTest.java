package lotto.lotto;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.io.input.Input;
import lotto.random.RandomImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService(new RandomImpl());

    @Test
    void purchaseLottoWithAmount() {
        // given
        int price = 8000;

        // when
        List<Lotto> lottos = lottoService.purchaseLottoWithAmount(price);

        // then
        Assertions.assertEquals(8, lottos.size());
    }

    @Test
    @DisplayName("당첨번호 발행")
    void issueWinningNumbers() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,4,5,2,6,3".getBytes());
        System.setIn(in);

        // when
        Lotto lotto = lottoService.issueWinningNumbers();

        // then
        Assertions.assertEquals(lotto.getNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}