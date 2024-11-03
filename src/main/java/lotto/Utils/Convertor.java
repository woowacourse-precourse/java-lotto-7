package lotto.Utils;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Stream;

public class Convertor {
    public static List<Integer> convert(String selectedNumbers) {
        try {
            return Stream.of(selectedNumbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static List<String> convert(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .toList();
    }

    public static String convert(int lottoPrice) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(lottoPrice) + "원";
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private Convertor() {}
}
