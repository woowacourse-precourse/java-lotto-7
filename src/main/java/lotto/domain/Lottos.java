package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Lottos {
    private List<Lotto> lottos;
    private static final int MIN_LOTTO_NUMBER=1;
    private static final int  MAX_LOTTO_NUMBER=45;
    private static final int LOTTO_SIZE=6;


    public Lottos(int count){
    lottos = new ArrayList<>();
    generateRandomNumber(count);

}

    private void generateRandomNumber(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBER,
                    LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
    }




}
