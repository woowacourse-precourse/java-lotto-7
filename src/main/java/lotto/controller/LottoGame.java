package lotto.controller;

import static java.util.stream.Collectors.toList;
import static lotto.Constant.MAX_NUMBER;
import static lotto.Constant.MIN_NUMBER;
import static lotto.Constant.MIN_WINNING_COUNT;
import static lotto.Constant.MONEY_UNIT;
import static lotto.Constant.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottos = new ArrayList<>();
    }

    public void startGame() {
        purchaseLotto();
        makeWinningNumber();
        makeRankResult();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String money = inputView.getMoney();
                InputValidator.validateMoney(money);
                int lottoCount = Integer.parseInt(money) / MONEY_UNIT;
                outputView.printLottoCount(lottoCount);
                makeLottos(lottoCount);
                break;
            } catch (NullPointerException | IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void makeLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = extractRandomNumbers();
            Lotto newLotto = new Lotto(randomNumbers);
            lottos.add(newLotto);
        }
        outputView.printLottoNumbers(lottos);
    }

    private List<Integer> extractRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return randomNumbers
                .stream()
                .sorted()
                .collect(toList());
    }

    private void makeWinningNumber() {
        List<Integer> winningLottoNumbers;
        winningLottoNumbers = receiveWinningLottoNumbers();
        while (true) {
            try {
                String uncheckedBonusNumber = inputView.getBonusNumber();
                InputValidator.validateBonusNumber(uncheckedBonusNumber);
                int bonusNumber = Integer.parseInt(uncheckedBonusNumber);
                winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> receiveWinningLottoNumbers() {
        String uncheckedWinningLottoNumbers;
        List<Integer> winningLottoNumbers;
        while (true) {
            try {
                uncheckedWinningLottoNumbers = inputView.getWinningLottoNumber();
                InputValidator.validateLottoNumber(uncheckedWinningLottoNumbers);
                winningLottoNumbers = InputValidator.makeLottoNumber(uncheckedWinningLottoNumbers);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return winningLottoNumbers;
    }

    private void makeRankResult() {
        Map<Rank, Integer> rankResult = initializeRankResult();
        for (Lotto lotto : lottos) {
            int sameNumberCount = winningLotto.countSameNumber(lotto);
            if (isWinning(sameNumberCount)) {
                Rank rank = winningLotto.calculateRank(lotto);
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
        double rateOfReturn = calculateRateOfReturn(rankResult);
        outputView.printResult(rankResult, rateOfReturn);
    }

    private Map<Rank, Integer> initializeRankResult() {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for(Rank rank: Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    private boolean isWinning(int sameNumberCount) {
        return sameNumberCount >= MIN_WINNING_COUNT;
    }

    private double calculateRateOfReturn(Map<Rank, Integer> rankResult) {
        int money = lottos.size() * MONEY_UNIT;
        int profit = 0;
        for (Rank rank : rankResult.keySet()) {
            int eachRankCount = rankResult.get(rank);
            int prizeMoney = rank.getReward();
            profit += (eachRankCount * prizeMoney);
        }
        double rateOfReturn = (double) profit / money * 100;
        return rateOfReturn;
    }
}
