package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final int ticketCount;
    private final List<Lotto> lottos;


    public Lottos(final int ticketCount) {
        this.ticketCount = ticketCount;
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottosNumber = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottosNumber.add(new Lotto(createLottoNumber()));
        }
        return lottosNumber;
    }

    public List<Number> createLottoNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public String getLottos() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : lottos) {
            result.append(lotto).append("\n");
        }
        return result.toString();
    }
}
