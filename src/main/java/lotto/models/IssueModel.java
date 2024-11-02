package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueModel {
    private final ArrayList<ArrayList<Integer>> allIssuedLottos;

    public IssueModel (int amount) {
        this.allIssuedLottos = IssueLottos(amount);
    }

    private ArrayList<Integer> pickRandomLottoNumbers() {
        return (ArrayList<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private ArrayList<Integer> sortNumbers (List<Integer> numbers) {
        Collections.sort(numbers);
        return (ArrayList<Integer>) numbers;
    }

    private ArrayList<ArrayList<Integer>> IssueLottos (int amount) {
        ArrayList<ArrayList<Integer>> Lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            ArrayList<Integer> singleLotto = sortNumbers(pickRandomLottoNumbers());
            Lottos.add(singleLotto);
        }
        return Lottos;
    }

    public ArrayList<ArrayList<Integer>> getAllIssuedLottos () {

        return allIssuedLottos;
    }

}
