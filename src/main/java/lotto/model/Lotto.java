package lotto.model;



import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        mutableNumbers.sort(null); // 리스트 정렬
        validate(mutableNumbers);
        this.numbers = mutableNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        checkForDuplicates(numbers);
        for (Integer number : numbers) {
            checkLottoNum(number);
        }
    }

    private void checkLottoNum(int number) {

        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 사이여야 합니다.");
        }
    }

    private void checkForDuplicates(List<Integer> numbers){
        for (int index=1; index<numbers.size(); index++){
            if (numbers.get(index).equals(numbers.get(index-1))){
                throw new IllegalArgumentException("[ERROR] 로또에 중복된 번호가 들어갈 수는 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
