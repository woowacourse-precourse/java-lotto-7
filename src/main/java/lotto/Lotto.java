package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lotto generate(){
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)){
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 이외의 숫자는 입력할 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현


    @Override
    public String toString() {
        return numbers.toString();
    }
}
