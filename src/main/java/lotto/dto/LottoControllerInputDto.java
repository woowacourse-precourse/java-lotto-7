package lotto.dto;

import java.util.List;
import lotto.exception.DtoExceptionMessage;
import lotto.exception.ExceptionUtils;

public record LottoControllerInputDto(int paymentAmount, List<Integer> winnerNumbers, int bonusNumber) {

    public LottoControllerInputDto {
        if (winnerNumbers == null) {
            throw ExceptionUtils.IllegalArgument(DtoExceptionMessage.NULL_EXCEPTION);
        }
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
            return new LottoControllerInputDto(this.paymentAmount, this.winnerNumbers, this.bonusNumber);
        }
    }
}
