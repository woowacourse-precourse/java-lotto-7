package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();

        Integer totalLottoCount = setTotalLottoCount(totalPrice);

        List<Lotto> lottos = drawLottery(totalLottoCount);

        printDrawingResult(lottos);

        Set<Integer> winningNumbers = setWinningNumbers();

        Integer bonusNumber = setBonusNumber(winningNumbers);

        return LottoGame.of(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    private Integer setBonusNumber(Set<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = readLine();
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        if(bonusNumber > 45 || bonusNumber <1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        return bonusNumber;
    }

    private Set<Integer> setWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        String[] inputNumbers = input.split(",");

        Set<Integer> winningNumbers = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(value -> {
                    if(value > 45 || value < 1) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
                    }
                    return true;
                })
                .collect(Collectors.toSet());

        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
        }
        return winningNumbers;
    }

    private void printDrawingResult(List<Lotto> lottos) {
        StringBuilder lottoPurchaseResult = new StringBuilder();
        lottoPurchaseResult.append("\n").append(lottos.size()).append("개를 구매했습니다.\n");
        lottos.stream()
                .forEach(lotto -> {
                    lottoPurchaseResult.append("[");
                    lottoPurchaseResult.append(lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")));
                    lottoPurchaseResult.append("]\n");
                });

        System.out.println(lottoPurchaseResult);
    }

    private List<Lotto> drawLottery(Integer totalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
        }
        return lottos;
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
