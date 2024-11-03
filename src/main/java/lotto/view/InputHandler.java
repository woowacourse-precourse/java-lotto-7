package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.InputValidator;

public class InputHandler {
    public final InputValidator inputValidator;

    public InputHandler(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int purchaseAmount = parseToInt(input);
                inputValidator.checkDividedBy1000(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNums() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] splitInput = input.trim().split(",");
                List<Integer> nums = Arrays.stream(splitInput)
                        .map(this::validateAndParseNumInRange).toList();
                return nums;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNum() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonusNum = validateAndParseNumInRange(input);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAndParseNumInRange(String input) {
        int num = parseToInt(input);
        inputValidator.checkInRange1To45(num);
        return num;
    }

    private int parseToInt(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자 형식이 아닙니다.");
        }
    }
}
