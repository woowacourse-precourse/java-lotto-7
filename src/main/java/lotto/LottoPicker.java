package lotto;

import java.util.*;

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
    public Map<WinningStatus, Integer> checkAllLottos(Lotto winLotto, int bonusNumber) {
        Map<WinningStatus, Integer> winCounters = new EnumMap<>(WinningStatus.class);

        for (WinningStatus status : WinningStatus.values()) {
            winCounters.put(status, 0);
        }

        for (Lotto lotto : lottos) {
            WinningStatus status = lotto.getWinningStatus(winLotto, bonusNumber);
            winCounters.put(status, winCounters.get(status) + 1);
        }

        return winCounters;
    }
}
