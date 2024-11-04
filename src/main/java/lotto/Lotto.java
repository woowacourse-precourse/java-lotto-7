package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    // numbers 의 접근 제어자인 private 은 변경할 수 없다.
    // Lotto 에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
    // 필드
    private final List<Integer> numbers;

    // 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 리스트 개수 검증 메소드
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 숫자 범위 검증 메소드
    public void checkValidRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이 숫자만 입력해 주세요.");
            }
        }
    }

    // 리스트 내 중복 숫자 검증 메소드
    public void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(); // 중복 확인을 위한 Set

        for (Integer number : numbers) {
            // Set에 숫자가 이미 존재하면 false 를 반환
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다");
            }
        }
    }
}
