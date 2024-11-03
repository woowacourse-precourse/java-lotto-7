package lotto;

import lotto.model.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            // 모든 로또들을 넣을 리스트
            List<Lotto> lottoList = new ArrayList<>();

            // 구입 금액 입력
            int total = Input.moneyInput();

            // 구매 개수를 출력
            Output.lottoTotalOutput(total);

            // 자동 로또 번호를 생성 및 출력
            for (int i = 0; i < total; i++) {
                List<Integer> autoLotto = Input.autoLottoInput();
                Collections.sort(autoLotto);
                Lotto lotto = new Lotto(autoLotto);
                lottoList.add(lotto);
                Output.lottoNumOutput(autoLotto);
            }

            // 당첨 번호를 입력
            List<Integer> winnerLotto = Input.winnerLottoNum();

            // 보너스 볼을 입력
            int bonusNum = Input.bonusNum();

            // 당첨 통계를 출력
            Output.resultOfLotto(lottoList, winnerLotto, bonusNum, total * 1000);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
