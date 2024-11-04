package lotto;

import java.util.List;

public class OutputLottoNumber {
    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
}