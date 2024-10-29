package lotto.view;

import java.util.List;

public class OutputView {

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }

    public static void printLottoNumbers(List<String> convertedNumbers) {
        convertedNumbers.stream()
            .forEach(System.out::println);
    }
}
