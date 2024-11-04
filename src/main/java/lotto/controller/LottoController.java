package lotto.controller;

import lotto.Message.ErrorMessage;
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
        Lotto winningNumber = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumber);

        LottoMatcher winningNumbers = new LottoMatcher(winningNumber, bonusNumber);
        startGame(winningNumbers, amount);
    }

    public int getTicketCount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            OutputView.printAmount(lottoAmount.getAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTicketCount();
        }
    }

    public void generateTickets(int amount) {
        for (int i = 0; i < amount; i++) {
            numbers = randomLotto.getRandNumbers();
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
            OutputView.printLottoNumber(lotto);
        }
    }

    public Lotto getWinningNumbers() {
        try {
            String input = InputView.inputWinningNum();
            numbers = Utils.parseToList(input);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(Lotto winningNumber) {
        try {
            BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNum());
            validateBonusNumber(bonusNumber.getNumber(), winningNumber);
            return bonusNumber.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }

    public static void startGame(LottoMatcher winningNumbers, int amount) {
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

    private static void validateBonusNumber(int bonusNumber, Lotto winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_IN_WINNING.toString());
        }
    }
}