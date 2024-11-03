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
        lotto.getNumbers();
        lottoList.add(lotto);
    }

    //테스트를 위한 설정 메서드
    void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        //unmodifiableList를 통해 오직 조회만 가능하도록
        return Collections.unmodifiableList(lottoList);
    }

}
