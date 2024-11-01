package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validate(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
        if (!numbers.matches("(\\d{1,2},){5}\\d{1,2}")) {  // 1~2자리 숫자와 쉼표 5개로 구성된 형식
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        String[] numbersStringArray = numbers.split(",");
        if (numbersStringArray.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        List<Integer> numbersIntegerList = new ArrayList<>();
        for (String i : numbersStringArray) {
            int num = Integer.parseInt(i);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이여야 합니다.");
            }
            if (numbersIntegerList.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다");
            }
            numbersIntegerList.add(num);
        }
        return numbersIntegerList;
    }

}