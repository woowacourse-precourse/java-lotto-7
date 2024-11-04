package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Input {

    private int PurchaseAmount;
    private List<Integer> LottoWinningNumbers;
    private int bonusNumber;

    public Input() {

    }

    public String getUserInput() {
        return  Console.readLine();
    }

    public void setPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputData=Integer.parseInt(getUserInput());
        System.out.println();

        validatePurchaseAmount1(inputData);
        validatePurchaseAmount2(inputData);
        this.PurchaseAmount= inputData;

    }

    void validatePurchaseAmount1(int inputData) {
        if(inputData %1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 1000원 단위여야 합니다.");
        }
    }

    void validatePurchaseAmount2(int inputData) {
        if(inputData <1000 ) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 최소한 1000원 이상이여야 합니다.");
        }
    }

    public void setLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputData=getUserInput();
        System.out.println();
        List<Integer> list=new ArrayList<>(convertLottoWinningNumbers(inputData));
        Collections.sort(list);
        this.LottoWinningNumbers= list;

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
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아니거나 중복되는 숫자가 존재합니다.");
        }
    }



    void validateLottoWinningNumbersScope(int num) {
        if(num <1 || num > 45) {
            throw new IllegalArgumentException(("[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다."));
        }
    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputData=getUserInput();
        System.out.println();

        int tmp=Integer.parseInt(inputData);
        validateBonusNumberScope(tmp);
        validateBonusNumDuplication(tmp);
        this.bonusNumber= Integer.parseInt(inputData);

    }

    void validateBonusNumDuplication(int bonusNum) {
        for( int num : LottoWinningNumbers) {
            if(bonusNum == num) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다");
            }
        }
    }

    void validateBonusNumberScope(int inputData) {

        if(inputData < 1 || inputData > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다");
        }

    }

    public int getPurchaseAmount() {
        return this.PurchaseAmount;
    }

    public List<Integer> getLottoWinningNumbers() {
        return this.LottoWinningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
