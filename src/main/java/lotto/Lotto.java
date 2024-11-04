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

        for(int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        Set<Integer> numSet = new HashSet<>(numbers); // 중복 확인
        if(numbers.size() != numSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 수가 존재합니다.");
        }
    }

    public void printNums() {
        // 오름차순 정렬
        List<Integer> ascNumbers = new ArrayList<>(numbers);
        Collections.sort(ascNumbers);

        int i = 0;
        for(Integer number : ascNumbers) {
            if(i == 0) {
                System.out.print("[");
                System.out.print(number);
                i++;
                continue;
            }
            System.out.print(", " + number);

            if(i == 5) {
                System.out.println("]");
            }
            i++;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
