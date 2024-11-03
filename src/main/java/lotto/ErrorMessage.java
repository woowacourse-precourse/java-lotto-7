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


}
