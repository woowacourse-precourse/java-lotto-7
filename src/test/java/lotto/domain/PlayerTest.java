package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("1000");
    }

    @Test
    void 플레이어_생성() {
        //given
        String money = "2000";

        //when
        Player player = new Player(money);

        //then
        assertEquals(2000, player.getMoney());
    }

    @Test
    void 생성자_비어있는금액_예외발생() {
        //given
        String money = "";

        //when then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Player(money));

        //then
        assertEquals("금액을 입력해 주세요.", exception.getMessage());
    }

    @Test
    void 숫자가아닌금액_예외발생() {
        //given
        String money = "abc";

        //when then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Player(money));

        //then
        assertEquals("금액은 숫자만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 로또티켓추가_유효한티켓_티켓추가() {
        //given
        Lotto ticket1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto ticket2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        List<Lotto> newTickets = Arrays.asList(ticket1, ticket2);

        //when
        player.addLottoTickets(newTickets);

        //then
        assertEquals(2, player.getLottoTickets().size());
    }

    @Test
    void 수익률계산_유효한금액과수익_정확한수익률() {
        //given
        int prize = 2000;
        player = new Player("1000");

        //when
        double profitRate = player.calculateProfitRate(prize);

        //then
        assertEquals(200.0, profitRate);
    }

}