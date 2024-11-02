package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.InputValidator.MAX_NUMBER;
import static lotto.InputValidator.MIN_NUMBER;

public class Lotto {

    private final static int MAX_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lotto generate(){
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_COUNT);
        return new Lotto(randomNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
        }
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)){
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 이외의 숫자는 입력할 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현


    @Override
    public String toString() {
        return numbers.toString();
    }
}
