package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.InputValidator.*;

public class LottoGame {

    public void start(){
        try {
            int purchaseAmount = getPurchaseAmount();
            List<Lotto> lottos = generateLottos(purchaseAmount);
            Lotto winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber(winningNumbers.getNumbers());
            LottoComparator result = new LottoComparator(lottos, winningNumbers, bonusNumber);
            result.calculateResult();
            result.printResult();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public int getPurchaseAmount(){
        while(true) {
            try {
                System.out.println("구매 금액을 입력해 주세요.");
                String input = Console.readLine();
                validateNumericNumber(input);
                Integer purchaseAmount = Integer.valueOf(input);
                validateThousandUnit(purchaseAmount);
                return purchaseAmount;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottos(int purchaseAmount){
        int ticket = purchaseAmount / LOTTO_PRICE_UNIT;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottos.add(Lotto.generate());
        }
        System.out.println("\n" + ticket + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    public Lotto getWinningNumbers(){
        while(true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateEmptyInput(input);
                List<Integer> winningNumbers = parseWinningNumbers(input);
                return new Lotto(winningNumbers);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers){
        while(true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateEmptyInput(input);
                validateBonusNumber(input);
                int bonusNumber = Integer.valueOf(input);
                validateBonusNumberRange(bonusNumber);
                validateNotDuplicate(winningNumbers, bonusNumber);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                winningNumbers.add(Integer.parseInt(token));
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다.");
            }
        }
        return winningNumbers;
    }


}
