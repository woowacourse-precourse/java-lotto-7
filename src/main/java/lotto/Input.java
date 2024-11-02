package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Input {

    private int PurchaseAmount;
    private Set<Integer> LottoWinningNumbers;
    private int bonusNumber;

    public Input() {

    }

    public void setPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        int inputData=Integer.parseInt(Console.readLine());
        validatePurchaseAmount(inputData);
        this.PurchaseAmount= inputData;

    }

    void validatePurchaseAmount(int inputData) {
        if(inputData %1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 1000원 단위여야 합니다.");
        }
    }

    public void setLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputData=Console.readLine();

        this.LottoWinningNumbers=convertLottoWinningNumbers(inputData);

    }

    public Set<Integer> convertLottoWinningNumbers(String inputData) {
        // "," 기준 분리 후 int형 배열로 변환해 반환
        String[] splitStringData=inputData.split(",");

        Set<Integer> splitIntData = new HashSet<>();
        int tmp;

        // Integer 형으로 변환
        for(int i=0;i<splitStringData.length;i++) {
            tmp=Integer.parseInt(splitStringData[i]);
            validateLottoWinningNumbersScope(tmp);
            splitIntData.add(tmp);
        }

        validateLottoWinningNumbersSize(splitIntData);

        return splitIntData;

    }

    void validateLottoWinningNumbersSize(Set<Integer> inputData) {
        if (inputData.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    void validateLottoWinningNumbersScope(int num) {
        if(num <1 || num > 45) {
            throw new IllegalArgumentException(("[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다."));
        }
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputData=Console.readLine();

        int tmp=Integer.parseInt(inputData);
        validateBonusNumberScope(tmp);

        this.bonusNumber= Integer.parseInt(inputData);

    }

    void validateBonusNumberScope(int inputData) {

        if(inputData < 1 || inputData > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나만 입력해야합니다");
        }

    }

    public int getPurchaseAmount() {
        return this.PurchaseAmount;
    }

    public Set<Integer> getLottoWinningNumbers() {
        return this.LottoWinningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
