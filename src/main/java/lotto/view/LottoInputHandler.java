package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoInputHandler {
    public int getTotalPurchase() {
        int totalPurchase = retryReadInteger();

        if (totalPurchase % LottoConstants.TICKET_PRICE != 0) {
            System.out.printf("[ERROR] 구입금액은 %d원 단위로 입력해 주세요.\n", LottoConstants.TICKET_PRICE);
            return getTotalPurchase();
        }
        return totalPurchase;
    }

    private int retryReadInteger() {
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요.");
            try {
                return parseInput(Console.readLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] 유효한 정수를 입력하세요. 다시 입력해 주세요. (%s)\n", e.getMessage());
            }
        }
    }

    public int parseInput(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                return parseNumberList(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.printf("[ERROR] 유효한 정수 리스트를 입력하세요. 다시 입력해 주세요. (%s)\n", e.getMessage());
            }
        }
    }

    public List<Integer> parseNumberList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers.split(",")) {
            numbers.add(Integer.parseInt(inputNumber.trim()));
        }
        return numbers;
    }
}