package lotto;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class ResultCalculator {
    public static void calculateResult(Data data) {
        for (Lotto ticket : data.getLottoTickets()) {
            UserPick userPick = data.getUserPick();

            boolean matchedBonus = checkMatchedBonus(userPick, ticket);
            int matchedCount = countCommonNumbers(userPick, ticket);

            int rank = getRankByMatchedNumbers(matchedCount, matchedBonus);
            if (rank != -1) {
                data.getResultAt(rank).increaseWonCount();
            }
        }
    }

    public static double calculateRateOfReturn(Data data) {
        double total = 0;
        for (Result result : data.getResults()) {
            total += result.getWonCount() * result.getRank().getPrize();
        }
        double rate = (total / data.getAmount()) * 100;
        rate = Math.round(rate * 10.0) / 10.0;
        return rate;
    }

    private static boolean checkMatchedBonus(UserPick userpick, Lotto ticket) {
        for (int i : ticket.getNumbersArrayList()) {
            if (i == userpick.getBonus()) {
                return true;
            }
        }
        return false;
    }

    private static int countCommonNumbers(UserPick userPick, Lotto ticket) {
        ArrayList<Integer> copy = new ArrayList<Integer>(userPick.getNumbersArrayList());
        copy.retainAll(ticket.getNumbersArrayList());

        return copy.size();
    }

    private static int getRankByMatchedNumbers(int matchedCount, boolean matchedBonus) {
        if (matchedCount == 6) {
            return 4;
        }
        if (matchedCount == 5 && matchedBonus == true) {
            return 3;
        }
        if (matchedCount == 5) {
            return 2;
        }
        if (matchedCount == 4) {
            return 1;
        }
        if (matchedCount == 3) {
            return 0;
        }
        return -1;
    }
}