package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {

    //구매할 로또 갯수
    private int purchaseAmount;
    //추후 수익률 계산을 위한 변수
    private int purchasePrice;
    private int bonusNum;
    private Lotto winningLotto;
    private List<Lotto> lottoList = new ArrayList<>();



    public void setPurchaseAmount(){
        while(true){
            if (getPurchaseAmount()) {
                break;
            }
        }
        //Console.close();
    }

    public void setLotto(){
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        for(int i = 0; i < purchaseAmount; i++){
            putRandomLotto();
        }
    }

    public void setWinningNumber(){
        while (true){
            if (getWinningNumbers()) {
                break;
            }
        }

    }

    public void setBonusNumber(){
        while (true){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String userInput = Console.readLine().trim();

            if (convertBonusNumToInteger(userInput)) {
                break;
            }
        }
    }

    private boolean convertBonusNumToInteger(String userInput) {
        try {
            bonusNum = LottoValidator.stringToInt(userInput);
            LottoValidator.checkRangeLotto(bonusNum);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        String[] winningNumber = userInput.split(",\\s*");
        for (String eachNum : winningNumber) {
            convertWinningNumToInteger(eachNum.trim(), winningNumbers);
        }
        if (setWinningLotto(winningNumbers)) {
            return true;
        }
        return false;
    }

    private boolean setWinningLotto(List<Integer> winningNumbers) {
        try {
            winningLotto = new Lotto(winningNumbers);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void convertWinningNumToInteger(String eachNum, List<Integer> winningNumbers) {
        try {
            int eachWinningNum = LottoValidator.stringToInt(eachNum);
            LottoValidator.checkRangeLotto(eachWinningNum);
            winningNumbers.add(eachWinningNum);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private boolean getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return processInput(userInput);
    }

    private boolean processInput(String userInput){
        try {
            int convertAmount = LottoValidator.stringToInt(userInput);
            return validateInput(convertAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validateInput(int convertAmount) {
        if (LottoValidator.unitValidator(convertAmount)) {
            purchasePrice = convertAmount;
            purchaseAmount = convertAmount / 1000;
            return true;
        }
        return false;
    }

    private void putRandomLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        //각 로또의 모든 숫자들 출력
        lotto.getNumbers();
        lottoList.add(lotto);
    }

    //테스트를 위한 설정 메서드
    void setPurchaseAmountForTest(int purchaseAmountForTest) {
        this.purchaseAmount = purchaseAmountForTest;
    }

    //테스트를 위한 조회 메서드
    public List<Lotto> getLottoList() {
        //unmodifiableList를 통해 오직 조회만 가능하도록
        return Collections.unmodifiableList(lottoList);
    }

}
