package lotto;

import java.util.*;

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
    }

    // TODO: 추가 기능

    public Lotto() {
        this.numbers = generateUniqueRandomNumbers();
    }

    // 중복되지 않는 랜덤 숫자 생성 메서드
    private List<Integer> generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < 6) {
            int number = random.nextInt(45) + 1;  // 1부터 45 사이의 난수 생성
            uniqueNumbers.add(number);
        }

        List<Integer> sortedNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedNumbers);  // 오름차순 정렬
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
