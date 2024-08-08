package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {

    /*
    username, age 라는 이름으로 데이터가 오는데 이 데이터를 받아서 저장할 수 있는 객체를 만들어야 함
     */
    private String username;
    private int age;

    /*
       getter, setter 를 이용해서 값을 꺼내고 넣을 수 있음
       자바 프로퍼티 접근법, 자바 빈 접근법
    */
}
