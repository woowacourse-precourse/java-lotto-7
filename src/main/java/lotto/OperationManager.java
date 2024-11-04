package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperationManager {
    private final IO io = new IO();
    List<Integer> winningNumbers = new ArrayList<>();
    List<Lotto> lottos;

    public void buy() {
        // 입력 받기
        String payment = io.readPayment();
        String winningNumberInput = io.readWinningNumber();
        String bonusNumber = io.readBonusNumber();

        // 로또 생성
        long purchaseAmount = Long.parseLong(payment) / 1000;
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }

        // 당첨 번호 리스트 생성
        String[] winningNumber = winningNumberInput.split(",");
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(winningNumber[i]));
        }
    }

    // TODO: 수익률 계산 구현

    public void result() {
        // TODO: result 전달
        io.printResult(result);
    }
}
