package lotto;

import java.util.HashSet;
import java.util.List;

public class Error {

    public static HashSet<Integer> lottoNumbers = new HashSet<>();

    public static void duplicates(List<Integer> numbers) {
        lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            addToHashSet(number);
        }
    }

    public static void addToHashSet(int number) {
        if (!lottoNumbers.add(number)) {
            throw new IllegalArgumentException("중복 값이 존재합니다.");
        }
    }

    public static void isThousand(int number) {
        if (number%1000!=0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야합니다.");
        }
    }
}
