package lotto.dto;

import java.util.List;

public class LottoControllerInputDto {
    private final int paymentAmount;
    private final List<Integer> winnerNumbers;
    private final int bonusNumber;

    private LottoControllerInputDto(Builder builder) {
        this.paymentAmount = builder.paymentAmount;
        this.winnerNumbers = builder.winnerNumbers;
        this.bonusNumber = builder.bonusNumber;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static class Builder {
        private int paymentAmount;
        private List<Integer> winnerNumbers;
        private int bonusNumber;

        public Builder paymentAmount(int paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder winnerNumbers(List<Integer> winnerNumbers) {
            this.winnerNumbers = winnerNumbers;
            return this;
        }

        public Builder bonusNumber(int bonusNumber) {
            this.bonusNumber = bonusNumber;
            return this;
        }

        public LottoControllerInputDto build() {
            return new LottoControllerInputDto(this);
        }
    }
}
