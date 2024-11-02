package lotto;

import java.util.List;

public class OutputView {
    private final List<List<Integer>> boughtLottoNumbers;

    public OutputView(List<List<Integer>> boughtLottoNumbers) {
        this.boughtLottoNumbers = boughtLottoNumbers;
    }

    public void outputLottoNumbers() {
        System.out.println(boughtLottoNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> boughtLottoNumber : boughtLottoNumbers) {
            System.out.println(boughtLottoNumber);
        }
    }

}
