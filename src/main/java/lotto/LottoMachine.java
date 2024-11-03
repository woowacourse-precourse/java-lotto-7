package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int COUNTS_OF_LOTTO = 6;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public void playMachine() {
        Purchase purchase = makePurchase();
        Lottos lottos = makeLottos(purchase.numberOfPurchases());
        showLottos(lottos);
        WinningNumbers winningNumbers = makeWinningNumbers();
        BonusNumber bonusNumber = makeBonusNumber(winningNumbers);
        calculateResults(lottos, winningNumbers, bonusNumber);
        showResult(purchase);
    }

    private Purchase makePurchase() {
        try {
            Purchase purchase = new Purchase(inputView.askPurchase());
            return purchase;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePurchase();
        }
    }

    private Lottos makeLottos(int numberOfPurchases) {
        try {
            Lottos lottos = new Lottos(makeLottoNumbers(numberOfPurchases));
            return lottos;
        } catch (IllegalStateException e) {
            return makeLottos(numberOfPurchases);
        }
    }

    private List<List<Integer>> makeLottoNumbers(int size) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> lottoCandidate = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoCandidate);
            lottoNumbers.add(lottoCandidate);
        }
        return lottoNumbers;
    }

    private void showLottos(Lottos lottos) {
        outputView.updateLottos(lottos.showAllNumbersOfLottos());
    }

    private WinningNumbers makeWinningNumbers() {
        try {
            List<String> dividedInput = handleWinningNumbers();
            WinningNumbers winningNumbers = new WinningNumbers(dividedInput);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningNumbers();
        }
    }

    private List<String> handleWinningNumbers() {
        String initialInput = inputView.askWinningNumbers();
        List<String> dividedInput = Arrays.asList(initialInput.split(","));
        Collections.sort(dividedInput);
        return dividedInput;
    }

    private BonusNumber makeBonusNumber(WinningNumbers winningNumbers) {
        try {
            String initialInput = inputView.askBonusNumber();
            List<String> dividedInput = Arrays.asList(initialInput.split(","));
            BonusNumber bonusNumber = new BonusNumber(dividedInput);
            checkDuplicateBonus(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeBonusNumber(winningNumbers);
        }
    }

    private void checkDuplicateBonus(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력하신 번호가 이미 당첨번호에 존재합니다.");
        }
    }

    public void calculateResults(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            Result rank = decideRank(lottos.lottoAt(i), winningNumbers, bonusNumber);
            rank.winningCountsUp();
        }
    }

    private Result decideRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        double count = 0;
        if (lotto.contains(bonusNumber.number())) {
            count += 0.5;
        }
        for (int i = 0; i < COUNTS_OF_LOTTO; i++) {
            if (lotto.contains(winningNumbers.numberAt(i))) {
                count += 1;
            }
        }
        return Result.getRank(count);
    }

    private void showResult(Purchase purchase) {
        outputView.updateResults(Result.values());
        double prizeRate = ((double)Result.totalPrize() / (double)purchase.money()) * 100;
        outputView.updatePrizeRate(prizeRate);
    }
}
