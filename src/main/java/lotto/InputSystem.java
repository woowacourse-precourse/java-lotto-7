package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputSystem {
    // 금액이 0원 보다 작거나 1000으로 나눠 떨어지지 않을 경우 예외 처리
    private static int validateAmount(){
        String input = Console.readLine();
        int amount = Integer.parseInt(input);
        if (amount <= 0 || amount%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        return amount;
    }

    public static int inputLottoPurchaseAmount(){
        while (true) {
            try {
                return validateAmount();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> convert(String[] inputLottoNumber){
        List<Integer> lottoNumber = new ArrayList<>();
        for (String number: inputLottoNumber){
            lottoNumber.add(Integer.parseInt(number));
        }
        return  lottoNumber;
    }

    public static List<Integer> inputLottoNumber(){
         String[] inputLottoNumber = Console.readLine().split(",");
         return convert(inputLottoNumber);
    }

    public static int validBonusNumber(List<Integer> winningNumber){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }

    public static int inputBonusNumber(List<Integer> winningNumber){
        int bonusNumber = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                bonusNumber = validBonusNumber(winningNumber);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
