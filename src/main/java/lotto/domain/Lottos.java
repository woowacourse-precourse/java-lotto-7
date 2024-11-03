package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private static final int MIN_LOTTO_NUMBER=1;
    private static final int  MAX_LOTTO_NUMBER=45;
    private static final int LOTTO_SIZE=6;


    public Lottos(long count){
    lottos = new ArrayList<>();
    generateRandomNumber(count);
}

    private void generateRandomNumber(long count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBER,
                    LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public  List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
