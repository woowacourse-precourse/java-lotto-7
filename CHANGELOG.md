#### 2024-11-04

##### Chores

*  gitignore에 package.json 추가 (5bdac8a7)

##### Documentation Changes

*  README.md 수정 (0327794e)
*  구현 기능 목록 수정 (0f19b2ca)
*  보너스 번호 입력에 대한 예외 처리 수정 (08a0ef14)
*  구현 기능 목록 수정 (31aacf74)
*  구현 기능 목록 수정 (7175e844)
*  구현 기능 목록 일부 수정 (6a6965ad)
*  README.md 작성 (5695cf00)

##### New Features

*  당첨 통계를 출력 (ce0aafa1)
*  당첨 결과를 통해 수익률을 계산 (97d1e97e)
*  구매한 로또의 당첨 결과 확인 (2cd3e0a6)
*  출력 메시지 템플릿 추가 (8da36d95)
*  로또의 당첨 등수를 반환하는 메서드 구현 (8c0aa0d7)
*  당첨에 대한 정보를 가진 enum 클래스인 WinningInfo 구현 (f313ef81)
*  보너스 번호 입력에 대한 예외 발생 시 입력 다시 받기 (6def088f)
*  보너스 번호 입력에 대한 검증부 구현 (82fb104c)
*  보너스 번호 입력부 구현 (1378f9a1)
*  당첨 번호 입력에 대한 검증부 구현 (98b91e1a)
*  로또 번호의 숫자 범위와 중복을 확인하는 기능 구현 (d891fb0b)
*  당첨 번호 입력부 구현 (0620ace4)
*  구매한 로또 수량과 로또 번호를 출력 (9fa3805e)
*  로또 수량만큼 로또 번호를 생성 (c1afde40)
*  LottoNumbersGenerator 클래스 구현 (bd6bdb92)
*  발행할 로또 수량 계산 (a80c68fb)
*  구입 금액을 검증하는 Budget 클래스 구현 (784fcd33)
*  로또 구입 금액 입력 받기 (700387eb)
*  setup project (99b19647)

##### Bug Fixes

*  OutputMessageTest 클래스 테스트 코드 수정 (5ca99dde)
*  테스트 코드에 대한 오류 수정 (c42cc240)
*  당첨 번호 입력 메시지 출력 시 개행 추가 (882f0e05)

##### Refactors

*  구입 금액 검증부 수정 (92c330ad)
*  validateBudget() 메서드의 메서드명 변경 (01522b90)
*  당첨금 합계를 담는 변수의 자료형을 long으로 변경 (2acac762)
*  보너스 번호 관련 에러 메시지 수정 (fb00639e)
*  당첨 번호 관련 에러 메시지 수정 (a64f1c41)
*  BonusNumber 클래스의 에러 메시지 상수를 클래스 분리 (e7e96b2f)
*  각 등수의 당첨 결과 출력 메시지 결정부를 메서드로 분리 (16164b84)
*  에러 메시지를 출력부를 printErrorMessage() 메서드로 교체 (7f14d42f)
*  에러 메시지 앞에 붙는 '[ERROR]' 표시를 상수로 선언 (ee484d6e)
*  에러 메시지 상수를 클래스 분리 (458b1970)
*  LottoInfo 클래스의 패키지 변경 (a01c7235)
*  LottoNumbersGenerator 클래스와 그 테스트 코드 패키지 변경 (0a3328a3)
*  checkWinningResult() 메서드 수정 (4a768339)
*  LottoMachine 클래스를 LottoController로 클래스명 변경 (2d5108a8)
*  당첨 통계 관련 메서드를 WinningStatistics 클래스로 분리 (c420b045)
*  로또를 구매하는 메서드를 Purchaser 클래스로 분리 (d119a45e)
*  purchaseLotto() 메서드 수정 (cf6f6759)
*  패키지명 변경 (10e0e601)
*  메시지 출력하는 부분을 모두 printMessage() 메서드로 교체 (aed7bccc)
*  로또 가격 상수의 클래스 이동 (9706c544)
*  LottoMachine 클래스를 service 패키지로 분리 (7f1f3251)
*  로또 번호 개수 확인 로직을 하나의 메서드로 분리 (0ed74d1e)
*  LottoNumberGenerator 클래스 내부 상수를 다른 클래스로 분리 (2078b784)
*  OutputView 내부의 상수를 다른 클래스로 분리 (f594f7ff)
*  InputView 내부의 상수를 다른 클래스로 분리 (ec8a00b7)
*  테스트 코드 패키지 분리 (18731668)
*  Budget, Lotto, LottoNumbersGenerator 클래스 domain 패키지로 분리 (59f1df89)
*  InputView, OutputView 클래스를 view 패키지로 분리 (222a6292)
*  BudgetTest 클래스 내부의 테스트 코드 중 메서드명 변경 (14a2219b)

##### Code Style Changes

*  미사용 import 문 제거 (f0db90a1)
*  자동 정렬 기능을 통한 코드 포매팅 (c50aeea8)
*  구현 기능 목록 오타 수정 (30928d0c)
*  BudgetTest 클래스 내부 미사용 import문 제거 (b3b01da1)

##### Tests

*  WinningInfoTest 클래스 테스트 코드 수정 (64805ed8)
*  WinningStatisticsTest 클래스 테스트 코드 추가 (4e8c9218)
*  WinningStatistics 클래스에 대한 테스트 코드 작성 (30758769)
*  Purchaser 클래스에 대한 테스트 코드 작성 (0f4beeb9)
*  OutputMessageTest 클래스 테스트 코드 추가 (feda057b)
*  LottoTest 클래스 테스트 코드 추가 (323b880d)
*  당첨에 대한 정보를 담고 있는 WinningInfo 클래스의 테스트 코드 작성 (764d7a1a)
*  BonusNumber 클래스에 대한 테스트 코드 작성 (1aecd376)
*  Lotto 클래스에 대한 테스트 코드 일부 수정 (4cc396c9)
*  당첨 번호 클래스에 대한 테스트 코드 작성 (7338335e)
*  LottoTest 클래스에 로또 번호의 숫자 범위를 확인하는 테스트 추가 (96d41b1e)
*  OutputMessage 클래스에 대한 테스트 코드 작성 (dc08f28e)
*  InputMessage 클래스에 대한 테스트 코드 작성 (b03a9d25)
*  LottoNumbersGenerator 클래스에 대한 테스트 코드 작성 (18342e8b)
*  BudgetTest 클래스에 기능 테스트 추가 (bd0f581e)
*  로또 구입 금액 입력 검증부에 대한 테스트 코드 작성 (4d016318)

#### 2024-11-04

##### Documentation Changes

*  README.md 수정 (0327794e)
*  구현 기능 목록 수정 (0f19b2ca)
*  보너스 번호 입력에 대한 예외 처리 수정 (08a0ef14)
*  구현 기능 목록 수정 (31aacf74)
*  구현 기능 목록 수정 (7175e844)
*  구현 기능 목록 일부 수정 (6a6965ad)
*  README.md 작성 (5695cf00)

##### New Features

*  당첨 통계를 출력 (ce0aafa1)
*  당첨 결과를 통해 수익률을 계산 (97d1e97e)
*  구매한 로또의 당첨 결과 확인 (2cd3e0a6)
*  출력 메시지 템플릿 추가 (8da36d95)
*  로또의 당첨 등수를 반환하는 메서드 구현 (8c0aa0d7)
*  당첨에 대한 정보를 가진 enum 클래스인 WinningInfo 구현 (f313ef81)
*  보너스 번호 입력에 대한 예외 발생 시 입력 다시 받기 (6def088f)
*  보너스 번호 입력에 대한 검증부 구현 (82fb104c)
*  보너스 번호 입력부 구현 (1378f9a1)
*  당첨 번호 입력에 대한 검증부 구현 (98b91e1a)
*  로또 번호의 숫자 범위와 중복을 확인하는 기능 구현 (d891fb0b)
*  당첨 번호 입력부 구현 (0620ace4)
*  구매한 로또 수량과 로또 번호를 출력 (9fa3805e)
*  로또 수량만큼 로또 번호를 생성 (c1afde40)
*  LottoNumbersGenerator 클래스 구현 (bd6bdb92)
*  발행할 로또 수량 계산 (a80c68fb)
*  구입 금액을 검증하는 Budget 클래스 구현 (784fcd33)
*  로또 구입 금액 입력 받기 (700387eb)
*  setup project (99b19647)

##### Bug Fixes

*  OutputMessageTest 클래스 테스트 코드 수정 (5ca99dde)
*  테스트 코드에 대한 오류 수정 (c42cc240)
*  당첨 번호 입력 메시지 출력 시 개행 추가 (882f0e05)

##### Refactors

*  구입 금액 검증부 수정 (92c330ad)
*  validateBudget() 메서드의 메서드명 변경 (01522b90)
*  당첨금 합계를 담는 변수의 자료형을 long으로 변경 (2acac762)
*  보너스 번호 관련 에러 메시지 수정 (fb00639e)
*  당첨 번호 관련 에러 메시지 수정 (a64f1c41)
*  BonusNumber 클래스의 에러 메시지 상수를 클래스 분리 (e7e96b2f)
*  각 등수의 당첨 결과 출력 메시지 결정부를 메서드로 분리 (16164b84)
*  에러 메시지를 출력부를 printErrorMessage() 메서드로 교체 (7f14d42f)
*  에러 메시지 앞에 붙는 '[ERROR]' 표시를 상수로 선언 (ee484d6e)
*  에러 메시지 상수를 클래스 분리 (458b1970)
*  LottoInfo 클래스의 패키지 변경 (a01c7235)
*  LottoNumbersGenerator 클래스와 그 테스트 코드 패키지 변경 (0a3328a3)
*  checkWinningResult() 메서드 수정 (4a768339)
*  LottoMachine 클래스를 LottoController로 클래스명 변경 (2d5108a8)
*  당첨 통계 관련 메서드를 WinningStatistics 클래스로 분리 (c420b045)
*  로또를 구매하는 메서드를 Purchaser 클래스로 분리 (d119a45e)
*  purchaseLotto() 메서드 수정 (cf6f6759)
*  패키지명 변경 (10e0e601)
*  메시지 출력하는 부분을 모두 printMessage() 메서드로 교체 (aed7bccc)
*  로또 가격 상수의 클래스 이동 (9706c544)
*  LottoMachine 클래스를 service 패키지로 분리 (7f1f3251)
*  로또 번호 개수 확인 로직을 하나의 메서드로 분리 (0ed74d1e)
*  LottoNumberGenerator 클래스 내부 상수를 다른 클래스로 분리 (2078b784)
*  OutputView 내부의 상수를 다른 클래스로 분리 (f594f7ff)
*  InputView 내부의 상수를 다른 클래스로 분리 (ec8a00b7)
*  테스트 코드 패키지 분리 (18731668)
*  Budget, Lotto, LottoNumbersGenerator 클래스 domain 패키지로 분리 (59f1df89)
*  InputView, OutputView 클래스를 view 패키지로 분리 (222a6292)
*  BudgetTest 클래스 내부의 테스트 코드 중 메서드명 변경 (14a2219b)

##### Code Style Changes

*  미사용 import 문 제거 (f0db90a1)
*  자동 정렬 기능을 통한 코드 포매팅 (c50aeea8)
*  구현 기능 목록 오타 수정 (30928d0c)
*  BudgetTest 클래스 내부 미사용 import문 제거 (b3b01da1)

##### Tests

*  WinningInfoTest 클래스 테스트 코드 수정 (64805ed8)
*  WinningStatisticsTest 클래스 테스트 코드 추가 (4e8c9218)
*  WinningStatistics 클래스에 대한 테스트 코드 작성 (30758769)
*  Purchaser 클래스에 대한 테스트 코드 작성 (0f4beeb9)
*  OutputMessageTest 클래스 테스트 코드 추가 (feda057b)
*  LottoTest 클래스 테스트 코드 추가 (323b880d)
*  당첨에 대한 정보를 담고 있는 WinningInfo 클래스의 테스트 코드 작성 (764d7a1a)
*  BonusNumber 클래스에 대한 테스트 코드 작성 (1aecd376)
*  Lotto 클래스에 대한 테스트 코드 일부 수정 (4cc396c9)
*  당첨 번호 클래스에 대한 테스트 코드 작성 (7338335e)
*  LottoTest 클래스에 로또 번호의 숫자 범위를 확인하는 테스트 추가 (96d41b1e)
*  OutputMessage 클래스에 대한 테스트 코드 작성 (dc08f28e)
*  InputMessage 클래스에 대한 테스트 코드 작성 (b03a9d25)
*  LottoNumbersGenerator 클래스에 대한 테스트 코드 작성 (18342e8b)
*  BudgetTest 클래스에 기능 테스트 추가 (bd0f581e)
*  로또 구입 금액 입력 검증부에 대한 테스트 코드 작성 (4d016318)

