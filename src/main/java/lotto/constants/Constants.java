package lotto.constants;

public enum Constants {

    // 로또 생성에 대한 상수
    LOTTO_STARTING_RANGE(1),
    LOTTO_END_RANGE(45),
    LOTTO_COUNT(6),
    BONUS_NUMBER_COUNT(1),

    // 각 등수에 대한 로또 번호 일치 개수 상수
    FIRST_PLACE(6),
    SECOND_PLACE(5),
    THIRD_PLACE(5),
    FOURTH_PLACE(4),
    FIFTH_PLACE(3),


    // 상금에 대한 상수
    FIRST_PLACE_PRIZE(2000000000),
    SECOND_PLACE_PRIZE(30000000),
    THIRD_PLACE_PRIZE(1500000),
    FOURTH_PLACE_PRIZE(50000),
    FIFTH_PLACE_PRIZE(5000),
    NOTHING_PLACE_PRIZE(0),

    // 수익률 계산을 위한 퍼센트 상수
    PERCENTAGE_NUMBER(100),

    // 로또 가격 단위 1000원 상수
    LOTTO_PRICE(1000);

    private int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
