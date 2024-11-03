package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;

import java.util.*;
import java.util.stream.Collectors;

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
        String bonusNumberInput = ConsoleInput.getBonusNumberInput();
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);

        return BonusNumber.of(LottoNumber.valueOf(bonusNumber), winningNumbers);
    }

    private LottoNumbers setWinningNumbers() {
        String input = ConsoleInput.getWinningNumbers();
        String[] inputNumbers = input.split(",");

        Set<LottoNumber> winningNumbers = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        return LottoNumbers.of(winningNumbers);
    }

    private void printDrawingResult(Lottos lottos) {

        StringBuilder lottoPurchaseResult = new StringBuilder();
        lottoPurchaseResult.append("\n").append(lottos.size()).append("개를 구매했습니다.\n");
        lottos.getValue()
                .forEach(lotto -> {
                    lottoPurchaseResult.append("[");
                    lottoPurchaseResult.append(lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")));
                    lottoPurchaseResult.append("]\n");
                });

        ConsoleOutput.print(String.valueOf(lottoPurchaseResult));
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
        String totalPrice = ConsoleInput.getTotalPrice();
        return LottoPrice.valueOf(Integer.parseInt(totalPrice));
    }
}
