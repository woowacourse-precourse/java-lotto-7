package lotto.core.constants;

public class Error {

    private Error() {}

    public static final class LottoError {
        private LottoError() {}

        public static final String INVALID_NUMBERS_LENGTH = "로또 번호는 6개여야 합니다.";

        public static final String INVALID_NUMBER_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    }

    public static final class LottoPurchaseAmountError {
        private LottoPurchaseAmountError() {}

        public static final String REQUIRED_AMOUNT = "로또 구입 금액을 입력해주세요.";

        public static final String INVALID_AMOUNT_FORMAT = "로또 구입 금액은 숫자만 입력해주세요.";

        public static final String BELOW_BASE_AMOUNT = "로또 구입 금액은 1000 이상의 숫자를 입력해주세요.";

        public static final String INVALID_BASE_AMOUNT_UNIT = "로또 구입 금액은 1000 단위의 숫자를 입력해주세요.";
    }

    public static final class LottoNumber {
        private LottoNumber() {}

        public static final String INVALID_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자만 가능합니다.";
    }

    public static final class BonusNumberError {
        private BonusNumberError() {}

        public static final String INVALID_NUMBER_FORMAT = "보너스 번호는 숫자만 입력해주세요.";

        public static final String REQUIRED_NUMBER = "보너스 번호를 입력해주세요.";

        public static final String DUPLICATED_NUMBER = "당첨 번호에 있는 번호는 보너스 번호로 입력할 수 없어요.";
    }

    public static final class WinningLottoError {
        private WinningLottoError() {}

        public static final String REQUIRED_NUMBER = "당첨 번호를 입력해주세요.";

        public static final String INVALID_NUMBER_FORMAT = "당첨 번호는 숫자만 입력해주세요.";
    }

    public static final class LottoTicketError {
        private LottoTicketError() {}

        public static final String FAILED_PUBLISHED = "로또 발행에 실패하였습니다.";
    }
}
