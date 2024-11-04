package lotto.input.producer;

import lotto.model.Lotto;
import lotto.util.AscendingSorter;

import java.util.ArrayList;
import java.util.List;

public class AllLottoNumbersProducer {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    public List<Lotto> getAllLottoNumbersByCount(int trial) {
        System.out.println(trial + "개를 구매했습니다.");
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < trial; i++) {
            List<Integer> randomNumbers = RandomNumbersProducer.getUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
            List<Integer> sortedRandomNumbers = AscendingSorter.run(randomNumbers);
            System.out.println(sortedRandomNumbers);
            lottoList.add(new Lotto(sortedRandomNumbers));
        }
        System.out.println(); // 입출력을 맞추기 위한 개행

        return lottoList;
    }
}
