package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.LottoBoundInfo;

public class LottoGenerator {

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            List<Integer> numbers = generateNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateNumbers() {
        int minimumNumber = LottoBoundInfo.MINIMUM_NUMBER.getInfo();
        int maximumNumber = LottoBoundInfo.MAXIMUM_NUMBER.getInfo();
        int lottoNumberCount = LottoBoundInfo.LOTTO_NUMBER_COUNT.getInfo();
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(minimumNumber, maximumNumber, lottoNumberCount);
        Collections.sort(numbers);
        return numbers;
    }

}
