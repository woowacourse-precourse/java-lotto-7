package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Input {

    private int PurchaseAmount;
    private int[] LottoWinningNumbers;
    private int bonusNumber;

    public Input() {

    }

    public void setPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputData=Console.readLine();
        this.PurchaseAmount= Integer.parseInt(inputData);

    }

    public void setLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputData=Console.readLine();

        this.LottoWinningNumbers=convertLottoWinningNumbers(inputData);

    }

    public int[] convertLottoWinningNumbers(String inputData) {
        // "," 기준 분리 후 int형 배열로 변환해 반환
        String[] splitStringData=inputData.split(",");

        if (splitStringData.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        int[] splitIntData=new int[6];

        for(int i=0;i<splitStringData.length;i++) {
            splitIntData[i]=Integer.parseInt(splitStringData[i]);
        }

        return splitIntData;

    }

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputData=Console.readLine();
        this.bonusNumber= Integer.parseInt(inputData);

    }

    public int getPurchaseAmount() {
        return this.PurchaseAmount;
    }

    public int[] getLottoWinningNumbers() {
        return this.LottoWinningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
