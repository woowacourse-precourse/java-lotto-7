package lotto.domain.view;

import lotto.common.exception.BusinessException;

import java.util.function.Predicate;

import static lotto.common.constant.LottoConst.*;

@FunctionalInterface
interface InputValidator<T> {
    T validate(String input) throws BusinessException;

    Predicate<Integer> IS_IN_LOTTO_RANGE = number -> number >= START_NUM && number <= END_NUM;
    Predicate<Integer> IS_NOT_SIX_NUMBERS = number -> number != LOTTO_NUM_COUNT;
    Predicate<Integer> IS_NOT_DIVISABLE_BY_LOTTO_PRICE = number -> number % LOTTO_PRICE != 0;
}