package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해주세요");
            int purchaseAmount = readPurchaseAmount();
            List<Integer> winningNums = readWinningNums();
            int bonusNum = readBonusNum();

            LottoGame lottoGame = new LottoGame(purchaseAmount, winningNums, bonusNum);
            lottoGame.printLottos();
            lottoGame.printResult();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static int readPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }


    public static List<Integer> readWinningNums() {
        String[] input = Console.readLine().split(",");
        List<Integer> winningNums = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNums(winningNums);
        return winningNums;
    }


    public static int readBonusNum() {
        int bonusNum = Integer.parseInt(Console.readLine());
        validateBonusNum(bonusNum);
        return bonusNum;
    }


    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static void validateWinningNums(List<Integer> winningNums) {
        if (winningNums.size() != 6 || winningNums.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
        if (winningNums.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
