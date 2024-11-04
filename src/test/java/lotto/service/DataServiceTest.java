package lotto.service;

import lotto.enumValue.CommonMessage;
import lotto.model.Lotto;
import lotto.service.lottoImpl.RandomNumberServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataServiceTest{
    private final String[] answerCorrect = new String[]{
            "1, 2, 3, 4, 5, 6",
            "11, 12, 13, 14, 15, 16",
            "21, 22, 23, 24, 25, 26"
    };

    private class MockRandomNumberServiceCorrect implements RandomNumberServiceImpl{
        @Override
        public List<Lotto> createRandomNumber(int tickets) {
            List<Lotto> lottos = new ArrayList<>();

            lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
            lottos.add(new Lotto(Arrays.asList(11,12,13,14,15,16)));
            lottos.add(new Lotto(Arrays.asList(21,22,23,24,25,26)));

            return lottos;
        }
    }
    private class MockRandomNumberServiceWrong implements RandomNumberServiceImpl{
        @Override
        public List<Lotto> createRandomNumber(int tickets) {
            List<Lotto> lottos = new ArrayList<>();

            lottos.add(new Lotto(Arrays.asList(1,2,3,4,5)));

            return lottos;
        }
    }

    @Test
    void 티켓_수에_맞추어_로또_티켓_생성() {
        DataService dataService = new DataService(new MockRandomNumberServiceCorrect());
        List<Lotto> lottos = dataService.createLottos(3);
        for(int i=0;i<3;i++){
            assertTrue(lottos.get(i).getNumbers().toString().contains(answerCorrect[i]), CommonMessage.FAIL.getMessange());
        }
    }

    @Test
    void 티켓_수에_맞추어_로또_티켓_생성_예외_테스트() {
        DataService dataService = new DataService(new MockRandomNumberServiceWrong());
        try {
            List<Lotto> lottos = dataService.createLottos(2);
        }catch (IllegalArgumentException e){
            assertTrue(e.getMessage().contains(CommonMessage.ERROR.getMessange()),  CommonMessage.FAIL.getMessange());
        }
    }
}
