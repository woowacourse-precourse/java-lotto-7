package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PickRandomLotto {
    private int lottoAmount;
    private List<List<Integer>> lottos;

    public PickRandomLotto(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.lottos = new ArrayList<>();
        pickRandomLotto();
    }

    private void pickRandomLotto() {
        for (int i = 0; i < lottoAmount; i++) {
            Set<Integer> lottoNumbers = new HashSet<>();

            while (lottoNumbers.size() < 6) {
                int randomLotto = Randoms.pickNumberInRange(1, 45);
                lottoNumbers.add(randomLotto);
            }
            lottos.add(new ArrayList<>(lottoNumbers));
        }
    }
    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
