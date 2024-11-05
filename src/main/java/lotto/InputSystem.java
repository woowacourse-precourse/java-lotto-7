package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoValidate.*;

public class InputSystem {
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

    private static List<Integer> convert(String[] inputLottoNumber){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String number : inputLottoNumber){
            try{
                lottoNumbers.add(Integer.parseInt(number));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자형태여야 합니다.");
            }
        }
        return  lottoNumbers;
    }

    // 로또 번호에 대한 검사
    private static void validate(List<Integer> lottoNumbers){
        validateSize(lottoNumbers);
        validateUnique(lottoNumbers);
        validateRange(lottoNumbers);
        validateType(lottoNumbers);
    }


    public static List<Integer> inputLottoNumber() {
        while (true) {
            try {
                OutputSystem.printMessageForLottoNumber();
                String[] inputLottoNumber = Console.readLine().split(",");
                List<Integer> lottoNumbers = convert(inputLottoNumber);
                validate(lottoNumbers);
                return lottoNumbers;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호에 대한 검사
    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        validBonusNumberUnique(winningNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    public static int inputBonusNumber(List<Integer> winningNumber){
        while(true){
            try{
                OutputSystem.printMessageForBonusNumber();
                int bonusNumber =  Integer.parseInt(Console.readLine());
                validateBonusNumber(winningNumber, bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
