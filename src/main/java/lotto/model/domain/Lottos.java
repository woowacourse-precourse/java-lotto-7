package lotto.model.domain;

import static lotto.constant.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int lottoCount) {
        lottos = new ArrayList<>();
        generateLottos(lottoCount);
    }

    public List<Lotto> get() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }


    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    MIN_NUM,
                    MAX_NUM,
                    SIZE)
                    .stream().sorted()
                    .toList();
            lottos.add(new Lotto(numbers));
        }
        lottos.stream().sorted();
    }

    @Override
    public String toString() {
        return String.join("\n", lottos.stream()
                .map(Lotto::toString)
                .toList());
    }
}
