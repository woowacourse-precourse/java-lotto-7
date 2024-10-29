package lotto.io;

import java.util.List;

public class OutputHandler {
    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다", lottoCount);
        System.out.println();
    }
    public static void printLottos(List<Integer> lottoNumbers) {
        List<String> numbers = convertToStringList(lottoNumbers);
        System.out.print("[");
        System.out.print(String.join(", ", numbers));
        System.out.println("]");
    }

    private static List<String> convertToStringList(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .toList();
    }
}
