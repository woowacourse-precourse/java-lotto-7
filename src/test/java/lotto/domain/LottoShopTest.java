package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    private final LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
    private final LottoTicketFactory factory = new LottoTicketFactory(numberGenerator);
    private final LottoShop lottoShop = new LottoShop(factory);

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000})
    public void 입력한_금액에_따라_로또_티켓_개수가_올바르게_생성된다(int money) {
        //given
        List<Lotto> lottos = lottoShop.purchaseLottoTickets(money);

        //when
        int lottoSize = lottos.size();

        //then
        Assertions.assertEquals(lottoSize, money / LottoShop.LOTTO_UNIT_PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 3500, 4200, 10001})
    void 로또구입_금액이_천원단위가_아니면_예외발생(int money) {
        assertThatThrownBy(() -> lottoShop.purchaseLottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 999})
    void 로또구입_금액이_천원미만이면_예외발생(int money) {
        assertThatThrownBy(() -> lottoShop.purchaseLottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구입 금액은 1,000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {100001, Integer.MAX_VALUE})
    void 로또구입_금액이_10만원_이상이면_예외발생(int money) {
        assertThatThrownBy(() -> lottoShop.purchaseLottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 구입 금액은 100,000원 입니다.");
    }

}