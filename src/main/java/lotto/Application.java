package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> lottoNumbers = Lotto.generateLottoNumbers();
        System.out.println("생성된 로또 번호: " + lottoNumbers);
    }
}
