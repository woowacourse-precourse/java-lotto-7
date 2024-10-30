package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.List;

public class LottoIssuer {
    private final Lotto[] lottos;

    public LottoIssuer(int price) {
        lottos = new Lotto[price / 1000];
        execute();
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : lottos) {
            result.append(lotto.getNumbers() + "\n");
        }
        return result.toString();
    }

    public int getLottoCount() {
        return this.lottos.length;
    }

    private void execute() {
        for(int i=0; i<lottos.length; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            lottos[i] = new Lotto(numbers);
        }
    }
}
