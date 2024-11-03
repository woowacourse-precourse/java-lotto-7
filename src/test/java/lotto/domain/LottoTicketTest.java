package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketTest {
    @ParameterizedTest
    @CsvSource({
        "-1_000",
        "100",
        "10_500",
        "1_000_000",


    })
    void 로또_티켓은_1000원_구매가능_최대10만원(int price){
        assertThatThrownBy(()->new LottoTicket(price))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @CsvSource({
        "14_000, 14",
        "1000, 1"
    })
    void 로또_티켓_발행_테스트(int price,int count){
        LottoTicket ticket = new LottoTicket(price);

        assertEquals(count,ticket.getCount());

    }
}
