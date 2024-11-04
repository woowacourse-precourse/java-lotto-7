package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PickRandomLotto {
    private int numberOfLottos;
    private List<List<Integer>> generatedLottos;

    public PickRandomLotto(int numberOfLottos) {
        this.numberOfLottos = numberOfLottos;
        this.generatedLottos = new ArrayList<>();
        generatedLottos();
    }

    private void generatedLottos() {
        for (int i = 0; i < numberOfLottos; i++) {
            Set<Integer> lottoNumbers = new HashSet<>();

            while (lottoNumbers.size() < 6) {
                int randomNumber = Randoms.pickNumberInRange(1, 45);
                lottoNumbers.add(randomNumber);
            }
            generatedLottos.add(new ArrayList<>(lottoNumbers));
        }
    }
    public List<List<Integer>> getGeneratedLottos() {
        return generatedLottos;
    }
}
