package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputSystem {
    // 금액이 0원 보다 작거나 1000으로 나눠 떨어지지 않을 경우 예외 처리
    private static void validateAmount(int amount){
        if (amount <= 0 || amount%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 크고 1000단위여야 합니다.");
        }
    }

    public static int inputLottoPurchaseAmount(){
        while (true) {
            try {
                OutputSystem.printMessageForPurchaseAmount();
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                validateAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void rangeCheck(int lottoNumber){
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    // 로또 번호가 숫자인지 체크
    private static void typeCheck(List<Integer> lottoNumbers, String number){
        try {
            int lottoNumber = Integer.parseInt(number.trim());
            // 범위 체크: 1부터 45 사이의 숫자인지 확인
            rangeCheck(lottoNumber);
            lottoNumbers.add(lottoNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private static List<Integer> convert(String[] inputLottoNumber){
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number: inputLottoNumber){
            typeCheck(lottoNumbers, number);
        }
        return  lottoNumbers;
    }

    // 로또 번호가 6개가 이닌 경우
    private static List<Integer> validate(List<Integer> lottoNumbers){
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 반드시 6개여야 합니다.");
        }
        return lottoNumbers;
    }

    public static List<Integer> inputLottoNumber(){
        while (true) {
            try {
                OutputSystem.printMessageForLottoNumber();
                String[] inputLottoNumber = Console.readLine().split(",");
                List<Integer> lottoNumbers = convert(inputLottoNumber);
                return validate(lottoNumbers);
            }
            catch (Exception e) {
                System.out.println("[ERROR] 알 수 없는 오류가 발생했습니다: ");
            }
        }
    }

    public static int validBonusNumber(List<Integer> winningNumber){
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        rangeCheck(bonusNumber);
        return bonusNumber;
    }

    public static int inputBonusNumber(List<Integer> winningNumber){
        int bonusNumber = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                OutputSystem.printMessageForBonusNumber();
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
