package lotto;

import java.util.List;

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
    public String showNumbers(){
        return numbers.toString();
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



    // TODO: 추가 기능 구현
}
