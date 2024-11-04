package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public String toString(){
        return numbers.toString();
    }

    public void checkMatch(Map<LottoMatch, Integer> lottoMatches, HashSet<Integer> winNumbers, int bonusNumber){
        int matches = countMatches(winNumbers);
        boolean winBonus = numbers.contains(bonusNumber);
        LottoMatch result = LottoMatch.valueOf(matches,winBonus);
        updateLottoMatches(lottoMatches, result);
    }

    private int countMatches(HashSet<Integer> winNumbers){
        int matchCount = 0;
        for(int lottonumber : numbers){
            if(winNumbers.contains(lottonumber)){
                matchCount++;
            }
        }
        return matchCount;
    }

    private void updateLottoMatches(Map<LottoMatch, Integer> lottoMatches, LottoMatch result){
        lottoMatches.put(result,lottoMatches.getOrDefault(result, 0) + 1);
    }
}
