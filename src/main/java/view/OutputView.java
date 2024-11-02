package view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void outputLottoNumbers(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        // 각 로또 번호 조합 출력
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }
}
