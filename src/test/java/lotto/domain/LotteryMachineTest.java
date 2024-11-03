package lotto.domain;

import lotto.dto.Result;
import lotto.util.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryMachineTest {
    int purchaseAmount;
    User user;
    LotteryMachine lotteryMachine;

    @BeforeEach
    void before() {
        purchaseAmount = 10000;
        user = new User(purchaseAmount);
        lotteryMachine = new LotteryMachine();
    }

    @Test
    void purchaseLottoTickets() {
        lotteryMachine.purchaseLottoTickets(user);
        Assertions.assertThat(user.getPurchasedLotto().size()).isEqualTo(purchaseAmount/LotteryMachine.LOTTO_TICKET_PRICE);
    }
    @DisplayName("구매 금액이 로또 가격단위가 아닐경우 예외가 발생한다.")
    @Test
    void 구매금액이_로또_가격단위가_아닐경우_예외가_발생한다() {
        User user1 = new User(7900);
        Assertions.assertThatThrownBy(()-> lotteryMachine.purchaseLottoTickets(user1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @DisplayName("구매 금액이 양수가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매금액이_양수가_아닐경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(()->new User(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        Assertions.assertThatThrownBy(()->new User(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void checkLottery() {
        //given
        lotteryMachine.purchaseLottoTickets(user);
        Result result = new Result("1,2,3,4,5,6");
        result.setBonusNumber(7);
        //when
        lotteryMachine.checkLottery(user,result);
        //then
        int purchasedLottoCount =0;
        for(LottoRank lottoRank : LottoRank.values()) {
            purchasedLottoCount +=user.getLottoResult().getRankCount(lottoRank);
        }
        Assertions.assertThat(purchasedLottoCount).isEqualTo(user.getPurchaseAmount()/LotteryMachine.LOTTO_TICKET_PRICE);
    }
}