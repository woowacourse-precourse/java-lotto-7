package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.LottoNumbers();
        System.out.println(lottoNumbers);

    }
}
