package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.List;

public class LottoIssuer {
    // TODO : 자료구조 수정해야
    private final Lotto[] lottos;

    public LottoIssuer(Price price) {
        if(price == null) {
            throw new IllegalArgumentException("[ERROR] " + "로또 구입 금액이 null이어서는 안 됩니다.");
        }
        lottos = new Lotto[price.getValue() / 1000];
        execute();
    }

    public Lotto[] getLottos() {
        return this.lottos;
    }

    public String getFormatLottos() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : lottos) {
            result.append(lotto.getPrintFormatNumber() + "\n");
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
