package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public void start(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        Lotto winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers.getNumbers());
        LottoComparator result = new LottoComparator(lottos, winningNumbers, bonusNumber);
        result.printResult();
    }

    public int getPurchaseAmount(){
        System.out.println("구매 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumericNumber(input);
        Integer purchaseAmount = Integer.valueOf(input);
        validateThousandUnit(purchaseAmount);
        return purchaseAmount;
    }

    public List<Lotto> generateLottos(int purchaseAmount){
        int ticket = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottos.add(Lotto.generate());
        }
        System.out.println(ticket + "개를 구매하였습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    public Lotto getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = parseWinningNumbers(input);
        return new Lotto(winningNumbers);
    }

    public int getBonusNumber(List<Integer> winningNumbers){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        Integer bonusNumber = Integer.valueOf(input);
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    private static List<Integer> parseWinningNumbers(String input) {
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
}
