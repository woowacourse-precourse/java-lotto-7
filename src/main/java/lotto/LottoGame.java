package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private int buyQuantity;
    private int purchaseCount;
    private List<Integer> numbers;
    private int bonusNumber;
    private List<Lotto> lottos = new ArrayList<>();
    ;

    public LottoGame() {

    }

    public Lotto generateLotto() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> mutableList = new ArrayList<>(integers);
        Lotto lotto = new Lotto(mutableList);
        Collections.sort(lotto.getNumbers());
        return lotto;
    }

    public void setLottos() {
        for (int i = 0; i < getPurchaseCount(); i++) {
            lottos.add(generateLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public void getLottosToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(purchaseCount+"개를 구매했습니다.").append("\n");
        for (int i = 0; i < lottos.size(); i++) {
            sb.append(lottos.get(i).getNumbers()).append("\n");
        }
        System.out.println(sb);
    }

    public int getPurchaseCount() {
        purchaseCount = buyQuantity / 1000;
        return purchaseCount;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
