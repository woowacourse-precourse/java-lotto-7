package lotto.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;


public class LottoService {
    private final InputValidator validator;

    public LottoService(InputValidator validator){
        this.validator = validator;
    }

    public int inputPurchaseAmount(){
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return validator.validatePurchaseAmount(input);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottoNumbers(int amount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < amount;){
            try{
                List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
                lottoList.add(new Lotto(randomNumbers));
                i++;
            }catch(IllegalArgumentException e){
                // 예외가 발생해도 반복문을 계속 진행하여 유효한 번호생성
            }
        }
        return lottoList;
    }

    public WinningNumbers inputWinningNumbers(){
        while(true){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbersInput = Console.readLine();
                List<Integer> winningNumbers = validator.validateWinningNumbers(winningNumbersInput);

                Lotto lotto = new Lotto(winningNumbers);

                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumberInput = Console.readLine();
                int bonusNumber = validator.validateBonusNumber(bonusNumberInput, winningNumbers);

                return new WinningNumbers(lotto, bonusNumber);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
