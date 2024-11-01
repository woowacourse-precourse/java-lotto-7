package lotto.model;

public class ErrorMessages {
    private ErrorMessages() {
    }

    public class Lotto {
        private Lotto() {
        }

        public static final String INVALID_SIZE = "로또 번호는 6개여야 합니다.";
        public static final String INVALID_RANGE = "로또 번호는 1에서 45 사이여야 합니다.";
        public static final String DUPLICATED = "로또 번호는 중복 되어서는 안됩니다.";
    }

    public class LottoTicket {
        private LottoTicket() {
        }

        public static final String RANK_IS_NULL = "등수가 아직 등록되지 않았습니다.";
    }
}
