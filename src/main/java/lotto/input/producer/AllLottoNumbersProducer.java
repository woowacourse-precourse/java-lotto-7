package lotto.input.producer;

import lotto.Lotto;
import lotto.util.AscendingSorter;

import java.util.ArrayList;
import java.util.List;

public class AllLottoNumbersProducer {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    public List<Lotto> getAllLottoNumbersByCount(int trial) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < trial; i++) {
            List<Integer> randomNumbers = RandomNumbersProducer.getUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
            List<Integer> sortedRandomNumbers = AscendingSorter.run(randomNumbers);
            lottoList.add(new Lotto(sortedRandomNumbers));
        }
        return lottoList;
    }
}
