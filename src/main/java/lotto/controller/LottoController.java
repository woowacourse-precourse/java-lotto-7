package lotto.controller;

import lotto.model.*;
import lotto.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final List<Lotto> tickets = new ArrayList<>();
    private static final RandomLotto randomLotto = new RandomLotto();

    private List<Integer> numbers;

    public void run() {
        start();
    }

    private void start() {
        int amount = getTicketCount();
        generateTickets(amount);
        Lotto winningNumber = getWinNumbers();
        int bonusNumber = getBonusNum();

        LottoMatcher winningNumbers = new LottoMatcher(winningNumber, bonusNumber);
        startGame(winningNumbers, amount);
    }

    private int getTicketCount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            OutputView.printAmount(lottoAmount.getAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTicketCount();
        }
    }

    private void generateTickets(int amount) {
        for (int i = 0; i < amount; i++) {
            numbers = randomLotto.getRandNumbers();
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
            OutputView.printLottoNumber(lotto);
        }
    }

    private Lotto getWinNumbers() {
        try {
            String input = InputView.inputWinningNum();
            numbers = Utils.parseToList(input);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    private int getBonusNum() {
        try {
            BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNum());
            return bonusNumber.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNum();
        }
    }

    private static void startGame(LottoMatcher winningNumbers, int amount) {
        Map<LottoRank, Integer> result = initResults();
        LottoRank rank;

        for (Lotto lotto : tickets) {
            rank = winningNumbers.determineRank(lotto);
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

    private static Map<LottoRank, Integer> initResults() {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}