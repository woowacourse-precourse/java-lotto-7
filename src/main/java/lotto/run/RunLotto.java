package lotto.run;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunLotto {
    static List<Lotto> lottos;
    static final int LOTTO_PRICE = 1000;

    public RunLotto() {

    }

    public static List<Lotto> generateLottos(long purchasePrice) {
        int lotteryCnt = Math.toIntExact(purchasePrice / LOTTO_PRICE);
        lottos = new ArrayList<>();
        for (int i = 0; i < lotteryCnt; i++) {
            issueLottos();
        }
        List<Lotto> lottos = getLottos();
        Output.printLottos(lottos);
        return lottos;
    }

    private static void issueLottos() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(sortedNumbers);
        lottos.add(lotto);
    }

    public static List<Lotto> getLottos() {
        return lottos;
    }
}
