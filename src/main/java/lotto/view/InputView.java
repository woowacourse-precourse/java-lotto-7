package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchasePrice() {
        String inputPurchasePrice;
        System.out.println("구입금액을 입력해 주세요.");
        inputPurchasePrice = Console.readLine();
        return convertToInt(inputPurchasePrice, "구매금액");
    }

    public static int getBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        return convertToInt(inputBonusNumber,"보너스 번호");
    }

    public static List<Integer> getWinningNums() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = convertToIntList(inputWinningNumbers);

        return winningNumbers;
    }

    public static int convertToInt(String inputStr, String type) {
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(type+"은(는) 정수여야합니다.");
        }
        return purchasePrice;
    }

    public static List<Integer> convertToIntList(String inputStr) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String[] splitNumbers = inputStr.split(",");
            if(splitNumbers.length==0)
                throw new IllegalArgumentException("당첨번호는 정수여야합니다.");
            for (int i = 0; i < splitNumbers.length; i++) {
                int winningNumber = Integer.parseInt(splitNumbers[i]);
                winningNumbers.add(winningNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨번호는 정수여야합니다.");
        }
        return winningNumbers;
    }
}
