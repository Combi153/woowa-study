# 문제 4

## 기능 목록

- [ ] 문자열을 검증하는 기능
  - [ ] 길이 검증 : 1이상 1,000 이하

- [ ] 문자를 변환하는 기능
  - [ ] 알파벳 대문자의 아스키 코드 변환 기능
  - [ ] 알파벳 소문자의 아스키 코드 변환 기능
  - [ ] 기타 문자는 변환하지 않는 기능

## 리팩토링

- 객체의 자율성을 보장할까, 아니면 수동적으로 활용할까
  - Word 객체는 검증 기능 외에 멤버변수를 List\<Integer> 자료형으로 변환하여 반환하는 기능만을 갖고 있다.
  - 멤버변수에 대한 어떠한 작업을 직접하지 않는 것이 객체의 자율성이 보장받지 못하는 느낌이다.
  - 하지만 멤버변수에 대한 작업(아스키 코드에 대한 변환) 등을 Word 객체 내에서 수행하는 것은 필요 이상의 정보를 알게 되는 느낌이다.

- Word, ReverseDictionary 두 객체는 사실 하나의 객체여야 하는 것이 아닐까
  - 두 객체를 합치도록 리팩토링해보자.
  - 두 객체를 합치면 객체가 무거워진다. 하나의 객체가 너무 많은 기능을 수행한다.

- 객체의 자율성을 보장하면서도, Word 객체가 필요한 정보만을 받도록 해보자.
  - 함수형 인터페이스를 활용하자.