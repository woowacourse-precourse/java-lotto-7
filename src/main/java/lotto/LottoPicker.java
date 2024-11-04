package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPicker {
    private final List<Lotto> lottos;

    public LottoPicker(int pickCount) {
        lottos = new ArrayList<Lotto>();
        generateLottos(pickCount);
    }

    private void generateLottos(int pickCount) {
        for(int i = 0; i < pickCount; i++) {
            lottos.add(new Lotto());
        }
    }
    public void printLottos() {
        StringBuilder output = new StringBuilder();
        output.append(lottos.size()).append("개를 구매했습니다.\n");

        for(Lotto lotto : lottos) {
            String numbers = Arrays.toString(lotto.getNumbers().toArray());
            output.append(numbers).append("\n");
        }
        System.out.println(output);
    }
}
