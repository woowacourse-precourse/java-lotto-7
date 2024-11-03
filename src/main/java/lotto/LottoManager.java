package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    private final LottoNumGenerator lottoNumGenerator;
    private final LottoStatistics lottoStatistics;
    private final Validate validate;
    List<Integer> checkBonusNumber;
    public LottoManager(){
        lottoNumGenerator = new LottoNumGenerator();
        lottoStatistics = new LottoStatistics();
        validate= new Validate();
    }

    public void runLottoManager(){
        int purchaseAmount =inputPurchaseAmount();
        lottoNumGenerator.convertToThousandUnit(purchaseAmount);
        lottoNumGenerator.allocateAutoLotto();
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNum = inputBonusNumber();
        lottoStatistics.setPurchaseAmount(purchaseAmount);
        lottoStatistics.checkSingleLotto(lottoNumGenerator.getGenerateAutoLotto(), winningNumbers, bonusNum);
        lottoStatistics.caculate();
        lottoStatistics.printResult();
    }

    public int inputPurchaseAmount(){
        while(true){
            try{
                System.out.println("구입 금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();
                // 구입 금액의 입력값 검증 -> 정상적인 int값인지
                validate.purchaseValidate(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winningNumbers = Arrays.stream(Console.readLine().split(","))
                        .map(Integer::parseInt)
                        .toList();
                checkBonusNumber = new ArrayList<>(winningNumbers);
                new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(winningNumbers);
        return winningNumbers;
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNum = Integer.parseInt(Console.readLine());
                checkBonusNumber.add(bonusNum);
                validate.bonusNumValidate(checkBonusNumber);
                return bonusNum;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
