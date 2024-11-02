package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class CalculateResult {
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;
    private final List<SingleResult> results;

    public CalculateResult(Lotto winningLotto, int bonusNumber) {
        this.winningLottoNumbers = winningLotto.getNumbers();
        this.bonusNumber = bonusNumber;
        this.results = new ArrayList<>();
    }

    public SingleResult findMatches(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();
        SingleResult result = new SingleResult();
        for (Integer number : numbers) {
            if (this.winningLottoNumbers.contains(number)) {
                result.countUp();
            }
        }
        if (numbers.contains(this.bonusNumber)) {
            result.bonusCountUp();
        }
        return result;
    }

    public void calculateMatches(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            this.results.add(findMatches(lotto));
        }
    }

    public List<SingleResult> getResults(){
        return this.results;
    }
}
