package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    public List<Integer> winningNum;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> ranNum = Numbers.get();
        //validate(ranNum);
        this.numbers = List.copyOf(ranNum);
    }

    public void setWinningNum(List<Integer> winningNum) {
        validate(winningNum);
        this.winningNum = winningNum;
    }

    private boolean checkNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if(number <1 || number>45){
                return false;
            }
        }
        return true;
    }

    private boolean checkNumberRepeated(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }

    public List<Integer> getWinningNum(){
        return winningNum;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(!checkNumberRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
        }
        if(!checkNumberRepeated(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 없는 숫자여야 합니다.");
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public void toLotto(){
        String input = Display.get();
        List<Integer> numbers = Arrays.stream(input.split(","))
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .toList();
        setWinningNum(winningNum);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    /*//머신 로또 번호
    public Lotto(){
        List<Integer> ranNum = Numbers.get();
        validate(ranNum);
    }*/


    // TODO: 추가 기능 구현
}
