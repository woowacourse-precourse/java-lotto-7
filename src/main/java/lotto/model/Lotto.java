package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> notDuplicateNumber = new HashSet<>(numbers);
        if(notDuplicateNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 기입될수 없습니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45 사이의 숫자여야 합니다.");
            }
        }

    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    public int compareTo(Lotto other){
        int count = 0;
        for(int number : numbers){
            if(other.getNumbers().contains(number)){
                count++;
            }
        }return count;
    }

    public boolean hasBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
    private List<Integer> sortNumbers(List<Integer> numbers){

        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }



    // TODO: 추가 기능 구현
}
