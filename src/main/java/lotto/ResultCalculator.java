package lotto;

import java.util.ArrayList;

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
            return 0;
        }
        if (matchedCount == 5 && matchedBonus == true) {
            return 1;
        }
        if (matchedCount == 5) {
            return 2;
        }
        if (matchedCount == 4) {
            return 3;
        }
        if (matchedCount == 3) {
            return 4;
        }
        return -1;
    }
}