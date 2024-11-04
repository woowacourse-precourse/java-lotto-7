package lotto;

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
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if(checkDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    //각 로또 번호 출력
    public void printLotto() {
        System.out.print("[");
        for(int i = 0; i < numbers.size(); i++) {
            printEachLottoNumber(i);
        }
        System.out.println("]");
    }

    //로또 출력 형식을 위한 함수
    private void printEachLottoNumber(int i) {
        System.out.print(numbers.get(i));
        if (i != numbers.size() - 1) {
            System.out.print(",");
        }
    }

}
