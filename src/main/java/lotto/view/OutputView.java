package lotto.view;

import java.util.List;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printBlank() {
        System.out.println();
    }
}
