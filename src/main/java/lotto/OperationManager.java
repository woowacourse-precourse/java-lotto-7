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

        winningCalculator(Integer.parseInt(bonusNumber));
    }

    public void winningCalculator(int BonusNumber) {
        Map<WinningStandard, Integer> winningResult = new HashMap<>();
        for (WinningStandard place : WinningStandard.values()) {
            winningResult.put(place, 0);
        }

        for (Lotto lotto : lottos) {
            List<Integer> matchingNumbers = winningNumbers.stream()
                    .filter(o -> lotto.getNumbers().stream().anyMatch(Predicate.isEqual(o)))
                    .collect(Collectors.toList());

            int matchingCount = matchingNumbers.size();
            boolean hasBonusNumber = lotto.getNumbers().contains(BonusNumber);

            for (WinningStandard place : WinningStandard.values()) {
                if (place.getMatchingNumber() == matchingCount
                        && place.isMatchingBonusNumber() == hasBonusNumber) {
                    winningResult.put(place, winningResult.get(place) + 1);
                    break;
                }
            }
        }

        io.printResult(winningResult, earningsRateCalculator(winningResult));
    }

    // TODO: 수익률 계산 구현
    public double earningsRateCalculator(Map<WinningStandard, Integer> winningResult) {
        long payment = lottos.size() * 1000L;
        long totalPrize = 0;

        for (Map.Entry<WinningStandard, Integer> entry : winningResult.entrySet()) {
            WinningStandard place = entry.getKey();
            int count = entry.getValue();
            totalPrize += place.getPrize() * count;
        }

        double earningsRate = (totalPrize / payment) * 100;

        return Math.round(earningsRate * 100.0) / 100.0;
    }

    public void result() {
        // TODO: result 전달
//        io.printResult(result);
    }
}
