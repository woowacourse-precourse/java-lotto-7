package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();

        Integer totalLottoCount = setTotalLottoCount(totalPrice);

        Lottos lottos = drawLottery(totalLottoCount);

        printDrawingResult(lottos);

        LottoNumbers winningNumbers = setWinningNumbers();

        Integer bonusNumber = setBonusNumber(winningNumbers);

        return LottoGame.of(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    private Integer setBonusNumber(LottoNumbers winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = readLine();
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        if(bonusNumber > 45 || bonusNumber <1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        if(winningNumbers.contains(LottoNumber.valueOf(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        return bonusNumber;
    }

    private LottoNumbers setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
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

        System.out.println(lottoPurchaseResult);
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
        System.out.println("구입금액을 입력해 주세요.");
        Integer totalPrice = Integer.parseInt(readLine());

        return LottoPrice.valueOf(totalPrice);
    }
}
