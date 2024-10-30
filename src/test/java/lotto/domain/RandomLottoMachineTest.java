package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.factory.RandomLottoMachine;
import lotto.domain.number.NumbersMaker;
import lotto.domain.number.RandomLottoNumberMaker;
import org.junit.jupiter.api.Test;

class RandomLottoMachineTest {

    private RandomLottoMachine lottoMachine;
    private NumbersMaker numbersMaker;
    private  Wallet wallet;

    @Test
    void 랜덤_로또_생성_개수_확인(){
        numbersMaker = new RandomLottoNumberMaker();
        wallet = new Wallet(5000);
        lottoMachine = new RandomLottoMachine(numbersMaker, wallet);

        List<Lotto> resultLotto = lottoMachine.makeLottos();
        int resultAmount = resultLotto.size();

        assertEquals(5, resultAmount);
    }



}