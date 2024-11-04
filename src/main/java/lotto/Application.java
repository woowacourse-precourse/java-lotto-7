package lotto;

import lotto.run.*;
import lotto.view.*;

import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        long purchasePrice = Input.inputNum();
        System.out.println(purchasePrice / 1000 + "개를 구매했습니다.");

        // 로또 번호 랜덤 선택 및 출력
        List<Lotto> lottos = RunLotto.generateLottos(purchasePrice);


    }
}
