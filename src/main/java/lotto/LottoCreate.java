package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCreate {
    private final int count;
    private final int amount;
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoCreate(String input) {
        int amount = validate(input);
        this.amount = amount;
        this.count = amount / 1000;
        createLotto();
    }

    private void createLotto() {
        for(int i = 0; i < count; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
    }

    private int validate(String input) {
        try {
            int amount = Integer.parseInt(input);
            if(amount % 1000 > 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000 단위로 입력하셔야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력하셔야 합니다.");
        }
    }

    public String getLottoCreateInfo() {
        String lottoListString = lottoList.stream()
                .map(lotto -> lotto.getSortedNumbers().toString())
                .collect(Collectors.joining("\n"));
        return lottoList.size() + "개를 구매했습니다.\n" + lottoListString;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getAmount() {
        return amount;
    }
}
