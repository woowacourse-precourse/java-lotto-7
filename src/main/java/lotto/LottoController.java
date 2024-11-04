package lotto;

import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoView view;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void start() {
        int purchaseAmount = requestValidPurchaseAmount();
        generateLottos(purchaseAmount);

        view.displayPurchasedLottos(lottos);

        List<Integer> winningNumbers = requestValidWinningNumbers();
        int bonusNumber = requestValidBonusNumber();

        Map<LottoRank, Integer> resultSummary = calculateResults(winningNumbers, bonusNumber);
        double earningsRate = calculateEarningsRate(resultSummary, purchaseAmount);

        view.displayResults(resultSummary, earningsRate);
    }

    private int requestValidPurchaseAmount() {
        while (true) {
            try {
                return view.requestPurchaseAmount();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 최소 1000원 이상이어야 합니다.");
            }
        }
    }

    private List<Integer> requestValidWinningNumbers() {
        while (true) {
            try {
                return view.requestWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호는 1~45 사이의 숫자 6개여야 합니다.");
            }
        }
    }

    private int requestValidBonusNumber() {
        while (true) {
            try {
                return view.requestBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void generateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        for (int i = 0; i < lottoCount; i++) {
            try {
                lottos.add(Lotto.generateRandomLotto());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<LottoRank, Integer> calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

            resultMap.put(rank, resultMap.get(rank) + 1);
        }

        return resultMap;
    }

    private double calculateEarningsRate(Map<LottoRank, Integer> resultSummary, int purchaseAmount) {
        int totalPrize = resultSummary.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}