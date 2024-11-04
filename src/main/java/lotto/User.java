package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {


    public List<Lotto> createLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public Map<Rank, Integer> countRank(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        List<Rank> ranks = lottos.stream().map(n -> n.countMatchNumber(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
        Map<Rank, Integer> winnings = new HashMap<>();
        for (Rank rank : ranks) {
            if (winnings.containsKey(rank)) {
                winnings.put(rank, winnings.get(rank) + 1);
                continue;
            }
            winnings.put(rank, 1);
        }
        return winnings;
    }
}
