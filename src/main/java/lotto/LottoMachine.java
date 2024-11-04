package lotto;

import lotto.numberGenerator.LottoRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PER_PRICE = 1000;
    private int userMoney;
    private List<List<Integer>> lotto = new ArrayList<>();
    private static InputReader inputReader = new InputReader();
    private static LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();

    public void readLottoPrice() {
        System.out.println("구입금액을 입력해 주세요");
        String money = inputReader.readUserInput();
        while (Integer.parseInt(money) / LOTTO_PER_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 " + LOTTO_PER_PRICE + "원 단위로 입력해주세요.");
            money = inputReader.readUserInput();
        }
        userMoney = Integer.parseInt(money);
    }

    public int calculateLottoCount(int userMoney) {
        return userMoney / LOTTO_PER_PRICE;
    }

    public List<Integer> purchaseLotto() {
        return lottoRandomNumberGenerator.generateLottoNumbers();
    }

    public void vendorLotto(){
        int lottoCount = calculateLottoCount(userMoney);
        for(int i=0; i<lottoCount; ++i){
            lotto.add(purchaseLotto());
        }
    }
}
