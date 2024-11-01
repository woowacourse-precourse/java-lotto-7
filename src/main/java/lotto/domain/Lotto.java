package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//여기서 enum을 사용하여 비교하게 만들면 된다.
//결과로 나올 수 있는 것들은 1~45까지의 숫자이기 때문에
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    //중복된 값을 처리하는 기능
    private void checkForDuplicates(List<Integer> numbers) {
        //HashSet은 중복된 값을 갖지 않는다는 것을 이용
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 값이 없어야 합니다.");
        }
    }

}
