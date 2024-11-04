package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers; //로또 번호를 저장하는 변수

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현

    // 오름차순으로 정렬 메서드
    public List<Integer> sortNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers); // numbers 리스트의 복사본
        Collections.sort(sortedNumbers); // 복사본을 정렬
        return sortedNumbers; // 정렬된 복사본 반환
    }
    // numbers 리스트를 반환하는 메서드 추가
    public List<Integer> getSortNumbers() {
        return sortNumbers();
    }

}
