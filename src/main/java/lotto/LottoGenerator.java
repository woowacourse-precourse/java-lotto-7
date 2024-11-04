package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator extends LottoNumber {
    private static final List<List<Integer>> generatedTickets = new ArrayList<>();

    public LottoGenerator(int numberOfTickets) {
        generateAndStoreTickets(numberOfTickets);
        displayTickets();
    }

    public static void generateAndStoreTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
            Collections.sort(ticket);
            generatedTickets.add(ticket);
        }
    }

    public static List<List<Integer>> getGeneratedTickets() {
        return generatedTickets;
    }

    public static void displayTickets() {
        System.out.println(generatedTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : generatedTickets) {
            System.out.println(ticket);
        }
    }
}
