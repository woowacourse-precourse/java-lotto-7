package lotto;

public enum ErrorMessage {      // 예외별 메시지 관리
    INVAILD_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위의 양수 입니다.") {
        // 구입 금액은 양수인 1000원 단위
        @Override
        public void validate(int amount) {
            if (amount > 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },

    INVAILD_WINNING_NUMBER("[ERROR] 당첨 번호는 6개 입니다.") {
        // 사용자가 입력한 당첨 번호의 숫자는 6개
        @Override
        public void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(getMessage());
            }
        }
    },


}
