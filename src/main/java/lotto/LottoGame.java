package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        int ticket = purchaseAmount / 1000;
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
                Integer bonusNumber = Integer.valueOf(input);
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
            winningNumbers.add(Integer.parseInt(token));
        }
        return winningNumbers;
    }

    public static void validateNumericNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    public static void validateThousandUnit(int purchaseNumber){
        if(purchaseNumber % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateNotDuplicate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
