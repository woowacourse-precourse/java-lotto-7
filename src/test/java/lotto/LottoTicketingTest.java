package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.util.ReflectionUtils;

import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketingTest {

    // 정해진 수만큼 발권이 되는지
    //
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "100000,100"})
    void 정해진_수만큼_티켓을_발권한다(int price, int count) {

        Purchase purchase = new Purchase(price);

        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);
        assertThat(lottos.getTickets().size()).isEqualTo(count);
    }
}