package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoText {
    public static List<Integer> ParseIntegerList(String numbers) {


        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
        if (!numbers.matches("(\\d{1,2},){5}\\d{1,2}")) {  // 1~2자리 숫자와 쉼표 5개로 구성된 형식
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        String[] numbersStringArray = numbers.split(",");

        List<Integer> numbersIntegerList = new ArrayList<>();
        for (String i : numbersStringArray) {
            int num = Integer.parseInt(i);
            numbersIntegerList.add(num);
        }
        return numbersIntegerList;
    }
}
