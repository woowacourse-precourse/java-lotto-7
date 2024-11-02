package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final int lottoPurchase;
    private final int bonusNumber;
    private final List<Integer> lottoNumbers;
    private final int lottoCount;
    final int LOTTO_PURCHASE_COUNT = 1000;

    public InputView() {
        this.lottoPurchase = lottoPurchase();
        this.lottoNumbers = lottoNumbers();
        this.bonusNumber = bonusNumber();
        this.lottoCount = lottoPurchase/LOTTO_PURCHASE_COUNT;
    }

    public int lottoPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoPurchase = Console.readLine();
        return Integer.parseInt(lottoPurchase);
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> lottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String rawNumbers = Console.readLine();
        String[] rawNumberSplit = rawNumbers.split(",");

        List<Integer> lottoNumbers = new ArrayList<>();

        for (String numberInput : rawNumberSplit) {
            int number = Integer.parseInt(numberInput);
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getLottoPurchase() {
        return lottoPurchase;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoCount(){
        return lottoCount;
    }
}
