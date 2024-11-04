package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.EnumManagement.InputViewEnum;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final int lottoPurchase;
    private final int lottoCount;
    private List<Integer> lottoNumbers;
    private int bonusNumber;
    final int LOTTO_PRICE = 1000;

    public InputView() {
        this.lottoPurchase = lottoPurchase();
        this.lottoCount = lottoPurchase / LOTTO_PRICE;
    }

    public int lottoPurchase() {
        System.out.println(InputViewEnum.PURCHASE_AMOUNT.getMessage());
        String lottoPurchase = Console.readLine();
        return Integer.parseInt(lottoPurchase);
    }

    public void bonusNumber() {
        System.out.println(InputViewEnum.BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void lottoNumbers() {
        System.out.println(InputViewEnum.LOTTO_NUMBER.getMessage());
        String rawNumbers = Console.readLine();
        String[] rawNumberSplit = rawNumbers.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String numberInput : rawNumberSplit) {
            int number = Integer.parseInt(numberInput);
            lottoNumbers.add(number);
        }

        this.lottoNumbers = lottoNumbers;
    }

    public void inputStart(OutputView outputView) {
        outputView.outputLottoNumbers();
        lottoNumbers();
        bonusNumber();
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

    public int getLottoCount() {
        return lottoCount;
    }
}
