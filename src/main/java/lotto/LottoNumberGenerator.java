package lotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*

IntStream.rangeClosed(1, 45): 1부터 45까지의 숫자를 생성합니다.
boxed(): 각 int 값을 Integer 객체로 박싱하여 처리할 수 있도록 합니다.
collect(Collectors.toList()): 스트림을 리스트로 변환합니다.
Collections.shuffle(numbers): 리스트의 숫자를 무작위로 섞습니다.
subList(0, TOTAL_LOTTO_NUMBERS): 섞인 리스트에서 첫 6개의 숫자를 추출합니다.
sorted(): 추출된 번호를 오름차순으로 정렬합니다.

*/
public class LottoNumberGenerator {
    private static final int TOTAL_LOTTO_NUMBERS = 6;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static List<Integer> generate() {
        // 1부터 45까지의 숫자 리스트 생성
        List<Integer> numbers = IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        // 리스트를 무작위로 섞음
        Collections.shuffle(numbers);
        // 첫 6개의 숫자를 추출하고 정렬
        return numbers.subList(0, TOTAL_LOTTO_NUMBERS)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}