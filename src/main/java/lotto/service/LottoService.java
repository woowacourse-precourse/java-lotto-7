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
        int[] TODO = countRank(tickets, mainValue, bonusValue);

        return Arrays.stream(TODO)
                .boxed()
                .collect(Collectors.toList());
    }

    public double drawProfitRate(List<Integer> rankCount, Payment payment) {
        Prize prize = new Prize(rankCount, payment);
        return prize.getProfitRate();
    }

    private int[] countRank(List<Ticket> tickets, List<Integer> mainValue, int bonusValue) {
        int[] rankCount = new int[5];
        for (Ticket ticket : tickets) {
            int match = countSame(ticket, mainValue);
            boolean hasBonus = hasBonusNumber(ticket, bonusValue);
            int index = findIndex(match, hasBonus);

            if (match >= 3) {
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
        if (matchCount == 6) { return 0; }
        if (matchCount == 5 && hasBonus) { return 1; }
        return 7 - matchCount;
    }
}
