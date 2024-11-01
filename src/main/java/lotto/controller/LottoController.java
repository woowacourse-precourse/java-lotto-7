package lotto.controller;

import lotto.model.*;
import lotto.utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final RandomLotto randomLotto = new RandomLotto();
    private static List<Integer> numbers;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        // Amount 설정
        int amount = inputAmount();

        // 갯수만큼의 랜덤 복권 생성
        setLottoNumbers(amount);

        // WinningNumbers 입력
        Lotto winningNumbers = inputWinningNum();

        // BonusNumber 입력
        int bonusNumber = inputBonusNumber();

        LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers, bonusNumber);

        // LottoGame 시작
        gameStart(lottos, lottoMatcher, amount);
    }

    private int inputAmount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            OutputView.printAmount(lottoAmount.getAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    private void setLottoNumbers(int amount) {
        for (int i = 0; i < amount; i++) {
            numbers = randomLotto.setRandNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            OutputView.printLottoNumber(lotto);
        }
    }

    private Lotto inputWinningNum() {
        try {
            String str = InputView.inputWinningNum();
            numbers = utils.StringToList(str);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    private int inputBonusNumber() {
        try {
            BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNum());
            return bonusNumber.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static void gameStart(List<Lotto> lottos, LottoMatcher playerLotto, int amount) {
        Map<LottoRank, Integer> result = setResult();
        LottoRank rank;

        for (Lotto lotto : lottos) {
            rank = playerLotto.determineRank(lotto);
            result.put(rank, result.get(rank) + 1);
        }

        printResults(result);
        printRevenue(result, amount);
    }

    private static void printResults(Map<LottoRank, Integer> results) {
        OutputView.printSuccess();
        for (LottoRank rank : results.keySet()) {
            printIfNotMiss(rank, results);
        }
    }

    private static void printIfNotMiss(LottoRank rank, Map<LottoRank, Integer> results) {
        if (rank != LottoRank.MISS) {
            int count = results.getOrDefault(rank, 0);
            OutputView.printResults(rank, count);
        }
    }

    private static void printRevenue(Map<LottoRank, Integer> result, int amount) {
        double revenue = 0;
        for (LottoRank rank : result.keySet()) {
            revenue += (double) rank.getPrice() / (amount * LOTTO_PRICE) * (result.get(rank)) * PERCENTAGE;
        }
        OutputView.printRevenue(revenue);
    }

    private static Map<LottoRank, Integer> setResult() {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}