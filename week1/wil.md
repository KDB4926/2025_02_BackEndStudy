# Weekly_I_Learned 1주차 C311197 김동빈

이번 1주차에는 웹, HTTP, API등의 개념을 학습하였습니다. 첫번째로 웹은 인터넷 위에서 동작하는 서비스 중 하나로 사용자들이 서로의 정보를 공유할 수 있는 장소입니다. 컴퓨터가 통신하는 구조에는 클라이언트-서버 모델이 있고 클라이언트가 서버에게 요청을 보내면 서버가 요청을 처리하고 응답해주는 방식입니다. 추가로 URL이 Host, Port, Path, Query, Scheme으로 구성되어있습니다. 두번째로 HTTP는 웹에서 데이터를 주고받는 서버-클라이언트 모델의 프로토콜입니다. HTTP 요청에는 start line, headers, body가 있고, 주요 메서드에는 GET, POST, PUT, PATCH, DELETE 가 있습니다. 주요 상태 코드로는 200 OK, 201 Created, 400 Bad Request, 404 Not Found, 500 Internal Server Error 가 있습니다. 세번째로 API는 한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해놓은 약속이자 소통 창구입니다. 자주 사용하는 API는 REST이고 REST의 구성요소에는 자원, 행위, 표현이 있습니다.

# 온라인 쇼핑몰 프로젝트 API 명세서

## 상품 기능
- 상품 등록: `POST /products`
- 상품 조회(전체): `GET /products`
- 상품 조회(단일): `GET /products/{id}`
- 상품 수정: `PUT /products/{id}`
- 상품 삭제: `DELETE /products/{id}`

## 주문 기능
- 주문 생성: `POST /orders`
- 주문 조회(전체): `GET /orders`
- 주문 조회(단일): `GET /orders/{id}`
- 주문 취소: `DELETE /orders/{id}`

<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/81f06496-d2ce-4516-ba4b-4c6396b6e53b" />
