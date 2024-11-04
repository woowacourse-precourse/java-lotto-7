package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    // 사용자의 입력 값을 받을 때 1~45의 숫자 범위 제한과 6개의 번호까지 받을 수 있게 제한
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER =45;
    private static final String ERROR_MESSAGE_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    private static final String ERROR_MESSAGE_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    //사용자가 6개의 번호를 입력 안할 시 예외처리
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
        }
    }
    // 사용자가 1~45까지의 번호를 입력 안할 시 예외처리
    private void validateRange(List<Integer> numbers){
        if(numbers.stream().anyMatch(number -> number <MIN_NUMBER || number > MAX_NUMBER)){
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        }
    }
    // 사용자가 중복된 숫자를 입력 시 예외처리
    private void validateDuplicate(List<Integer> numbers){
        if (new HashSet<>(numbers).size() != LOTTO_SIZE){
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE);
        }
    }
    //특정 번호가 현재 호또 번호에 포함되었는지 확인
    public boolean contains(int number){
        return numbers.contains(number);
    }
    // 다른 로또와 비교를 해서 일치하는 번호의 개수를 반환
    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }
    //현재 로또의 번호들을 반환
    public List<Integer> getNumbers(){
        return List.copyOf(numbers);
    }
}
