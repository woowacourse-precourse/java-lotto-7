package lotto;

import lotto.dto.Rank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> uniqueNumbers=new HashSet<>(numbers);
        if(uniqueNumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 들어갈 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank checkWining(List<Integer> winingLotto, int bonus) {
        int count=0;
        boolean bonusMatched=false;
        for(int num:numbers){
            if(winingLotto.contains(num)){
                count++;
            }
        }
        if(count==5){
            bonusMatched=numbers.contains(bonus);
        }
        return Rank.valueOfMatchCount(count,bonusMatched);
    }

}
