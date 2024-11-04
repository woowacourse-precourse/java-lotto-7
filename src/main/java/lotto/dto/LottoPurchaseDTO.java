package lotto.dto;

import java.util.List;

public class LottoPurchaseDTO {
    private final int price;
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    public LottoPurchaseDTO(int price, List<Integer> lottoNumbers, int bonusNumber) {
        this.price = price;
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
