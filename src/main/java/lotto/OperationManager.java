package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperationManager {
    private final IO io = new IO();
    List<Lotto> lottos;

    public void buy() {
        // 입력 받기
        String payment = io.readPayment();
        String winningNumberInput = io.readWinningNumber();
        String bonusNumber = io.readBonusNumber();

        // 로또 생성
        long purchaseAmount = Long.parseLong(payment)/1000;
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }

        // 당첨 번호 리스트 생성
        List<Integer> winningNumbers = new ArrayList<>();
        String[] winningNumber = winningNumberInput.split(",");
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(winningNumber[i]));
        }


    }

    public void result() {
        // TODO: result 전달
        io.printResult(result);
    }
}
