package lotto.domain;

import lotto.dto.Result;
import lotto.util.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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