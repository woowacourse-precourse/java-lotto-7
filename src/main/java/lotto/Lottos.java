package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void issueByAmount(int price) {
        int lottoQuantity = price / 1000;

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Utils.generateRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
    }
}
