package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
        validateDuplicate(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {

        for (int i = 0; i < numbers.size() - 1; i++) {

            if(numbers.get(i).equals(numbers.get(i+1))){
                throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 중복될 수 없습니다.");
            }

        }
    }

    /// 로또에 저장된 숫자들을 출력
    public void printNumbers() {

        StringBuilder print = new StringBuilder("["); // 문자열을 자주 바꿔야하기 때문에 StringBuilder 사용

        for (int i = 0; i < numbers.size(); i++) {

            print.append(numbers.get(i));// numbers 배열 요소들을 ,를 구분자로 문자열에 더해줌
            if (i != numbers.size() - 1) {
                print.append(", ");
            }

        }
        print.append("]");

        System.out.println(print);
    }
}
