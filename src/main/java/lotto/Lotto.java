package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.PrizeTier ;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        this.numbers = new ArrayList<>();
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        
        /*TODO
        * - 오름차순 정렬된 상태 검증필요*/

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if(verifyDuplicated(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되선 안됩니다.");
        }
    }

    static public boolean verifyDuplicated(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);

        return set.size() != list.size();
    }

    public List<Integer> getNumbers(){
        return new ArrayList<>(this.numbers);
    }


    public int getMatchedNumbersCount(Lotto target){

        Set<Integer> numSet = new HashSet<Integer>(target.getNumbers());
        int matchCount = 0;
        int totalCount = numbers.size() + target.getNumbers().size();
        numSet.addAll(numbers);
        matchCount = totalCount - numSet.size();

        return matchCount;
    }

    public boolean isNumberIncluded(int number){
        return numbers.contains(number);
    }

    public PrizeTier  checkPrizeTier (Lotto winLotto, int bonusNum){

        boolean isBonusNumMatch = this.isNumberIncluded(bonusNum);
        int matchCount = this.getMatchedNumbersCount(winLotto);

        return PrizeTier .checkPrizeTier (matchCount,isBonusNumMatch);
    }
}
