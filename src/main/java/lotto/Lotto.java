package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    private static void duplication(List<Integer> numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer number : numbers) {
            map.put(number, 1);
        }
        if(map.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 포함하고 있습니다.");
        }
    }
    // 로또 번호를 생성하는 정적 메서드
    public static List<Integer> lottoNumber(String str) {
        List<Integer> numbers = new ArrayList<>();
        String[] input = str.split(",");

        try {
            for (String s : input) {
                numbers.add(Integer.parseInt(s.trim())); // 입력 값의 앞뒤 공백 제거
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자만 입력해야 합니다.");
        }
        // 유효성 검사
        validate(numbers);
        duplication(numbers);
        return numbers;
    }

}