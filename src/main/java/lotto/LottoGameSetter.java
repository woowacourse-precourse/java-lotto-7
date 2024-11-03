package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;

import java.util.*;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();
        Integer totalLottoCount = setTotalLottoCount(totalPrice);
        Lottos lottos = drawLottery(totalLottoCount);

        printDrawingResult(lottos);

        LottoNumbers winningNumbers = setWinningNumbers();
        BonusNumber bonusNumber = setBonusNumber(winningNumbers);

        return LottoGame.of(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    private BonusNumber setBonusNumber(LottoNumbers winningNumbers) {
        return BonusNumber.of(ConsoleInput.getBonusNumberInput(), winningNumbers);
    }

    private LottoNumbers setWinningNumbers() {
        return LottoNumbers.from(ConsoleInput.getWinningNumbers());
    }

    private void printDrawingResult(Lottos lottos) {
        ConsoleOutput.print(lottos.toString());
    }

    private Lottos drawLottery(Integer totalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }
        return Lottos.of(lottos);
    }

    private Integer setTotalLottoCount(LottoPrice totalPrice) {
        return totalPrice.getValue() / 1000;
    }

    private LottoPrice setTotalPrice() {
        return LottoPrice.valueOf(ConsoleInput.getTotalPrice());
    }
}
