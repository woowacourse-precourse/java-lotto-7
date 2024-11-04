package lotto.run;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class Choice {
    static List<Lotto> lottos;

    private List<Lotto> generateLottos(long purchasePrice) {
        issueLottos();
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

    public List<Lotto> getLottos() {
        return lottos;
    }
}
