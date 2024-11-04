package lotto.dto;

import java.util.List;

public record LottoControllerInputDto(int paymentAmount, List<Integer> winnerNumbers, int bonusNumber) {

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
            return new LottoControllerInputDto(this.paymentAmount, this.winnerNumbers, this.bonusNumber);
        }
    }
}
