package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int prizeTier = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> set = Set.copyOf(numbers);
        if(set.size()<numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void setPrizeTier(int prizeTier){
        if(prizeTier < 0 || prizeTier> 5) {
            throw new IllegalArgumentException("당첨 등수의 범위는 0~5등 입니다.");
        }
        this.prizeTier = prizeTier;
    }

    public int getPrizeTier(){
        return prizeTier;
    }
}
