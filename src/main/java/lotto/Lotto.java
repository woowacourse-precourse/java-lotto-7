package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.PrizeTier ;
import lotto.utils.NumberList;
import lotto.utils.Validator;

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

        try {
            Validator.validateListSize(numbers, NumberList.MAX_SIZE);
            Validator.validateDuplicate(numbers);
        }catch(IllegalArgumentException exception){
            throw new IllegalStateException(exception.getMessage(),exception);
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
