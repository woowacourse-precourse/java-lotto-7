package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.WinningStandard;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoManager {
    private final int PURCHASE_UNIT = 1000;
    private final int START = 1;
    private final int END = 45;
    private final int COUNT = 1;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<WinningStandard, Integer> winningResult = new HashMap<>();
    private Lotto winningLotto;
    private long payment;
    private int bonusNumber;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public List<Lotto> create(long payment) {
        this.payment = payment;
        long purchaseAmount = payment / PURCHASE_UNIT;
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public void createWinningLotto(String writeNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] writeNumbers = writeNumber.split(",");
        for (String s : writeNumbers) {
            validate(s);
            winningNumbers.add(Integer.parseInt(s));
        }
        winningLotto = new Lotto(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void initWinningResult() {
        for (WinningStandard place : WinningStandard.values()) {
            winningResult.put(place, 0);
        }
    }

    public Map<WinningStandard, Integer> winningCalculator() {
        for (Lotto lotto : lottos) {
            List<Integer> matchingNumbers = winningLotto.getNumbers().stream()
                    .filter(o -> lotto.getNumbers().stream().anyMatch(Predicate.isEqual(o)))
                    .collect(Collectors.toList());
            winningResultParsing(matchingNumbers, lotto);
        }
        return winningResult;
    }

    public void winningResultParsing(List<Integer> matchingNumbers, Lotto lotto) {
        int matchingCount = matchingNumbers.size();
        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

        for (WinningStandard place : WinningStandard.values()) {
            if (place.getMatchingNumber() == matchingCount
                    && place.isMatchingBonusNumber() == hasBonusNumber) {
                winningResult.put(place, winningResult.get(place) + 1);
                break;
            }
        }
    }

    public double earningsRateCalculator() {
        long totalPrize = 0;

        for (Map.Entry<WinningStandard, Integer> entry : winningResult.entrySet()) {
            WinningStandard place = entry.getKey();
            long count = entry.getValue();
            totalPrize += place.getPrize() * count;
        }
        double earningsRate = ((double) totalPrize / payment) * 100;

        return Math.round(earningsRate * 100.0) / 100.0;
    }

    public void validate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 형식입니다.");
        }
    }
}
