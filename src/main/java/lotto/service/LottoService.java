package lotto.service;

import lotto.model.Prize;
import lotto.view.InputView;
import lotto.model.BonusNumber;
import lotto.model.MainNumber;
import lotto.vo.Payment;
import lotto.vo.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final int RANK_STAGE = 5;
    private static final int RANK_PIVOT = 3;
    private static final int SIX_MATCH = 6;
    private static final int FIVE_MATCH = 5;
    private static final int FIRST_PRIZE_INDEX = 0;
    private static final int SECOND_PRIZE_INDEX = 1;
    private static final int CONVERSION_CONSTANT = 7;
    public Payment takePayment() {
        while (true) {
            try {
                String money = InputView.inputMoney();
                return new Payment(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public MainNumber takeMainNum() {
        while (true) {
            try {
                String mainInput = InputView.inputMainNumber();
                return new MainNumber(mainInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber takeBonusNum(MainNumber mainNumber) {
        while (true) {
            try {
                String bonusInput = InputView.inputBonusNumber();
                return new BonusNumber(bonusInput, mainNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> takeRankCount(List<Ticket> tickets, MainNumber mainNumber, BonusNumber bonusNumber) {
        List<Integer> mainValue = mainNumber.getNumbers();
        int bonusValue = bonusNumber.getNumber();
        int[] countRank = countRank(tickets, mainValue, bonusValue);

        return Arrays.stream(countRank)
                .boxed()
                .collect(Collectors.toList());
    }

    public double drawProfitRate(List<Integer> rankCount, Payment payment) {
        Prize prize = new Prize(rankCount, payment);
        return prize.getProfitRate();
    }

    private int[] countRank(List<Ticket> tickets, List<Integer> mainValue, int bonusValue) {
        int[] rankCount = new int[RANK_STAGE];
        for (Ticket ticket : tickets) {
            int match = countSame(ticket, mainValue);
            boolean hasBonus = hasBonusNumber(ticket, bonusValue);
            int index = findIndex(match, hasBonus);

            if (match >= RANK_PIVOT) {
                rankCount[index]++;
            }
        }
        return rankCount;
    }

    private int countSame(Ticket ticket, List<Integer> mainValue) {
        return (int) mainValue.stream()
                .filter(ticket.getTicket()::contains)
                .count();
    }

    private boolean hasBonusNumber(Ticket ticket, int bonusValue) {
        return ticket.getTicket().contains(bonusValue);
    }

    private int findIndex(int matchCount, boolean hasBonus) {
        if (matchCount == SIX_MATCH) { return FIRST_PRIZE_INDEX; }
        if (matchCount == FIVE_MATCH && hasBonus) { return SECOND_PRIZE_INDEX; }
        return CONVERSION_CONSTANT - matchCount;
    }
}
