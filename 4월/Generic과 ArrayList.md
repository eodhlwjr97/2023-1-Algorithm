##### Generic 
```java
List<Integer> list = new List<>();
```
List 같이 꺽쇠<> 안에 클래스 타입이 명시된 패턴을 자주 발견할 수 있다.   
     
아래와 같이 백준의 촌수계산 문제를 풀다가 생소한 패턴을 보았고, 이에 대해 공부한 것을 정리하려고 한다
```java
List<Integer>[] list = new ArrayList[N+1];

List<Integer> list = new ArrayList<>()[N+1]; // compile error
List<Integer> list = new ArrayList[N+1]; // compile error
List<Integer>[] list = new ArrayList<>()[N+1]; // compile error
List<Integer>[] list = new ArrayList<>[N+1]; // compile error
List<Integer>() list = new ArrayList<>()[N+1]; // compile error
List<Integer>() list = new ArrayList[N+1]; // compile error
```
---
일단, Generic 에 대해 알아보자.    
    
JAVA에서 Generic은 
  1) 데이터 형식에 의존하지 않고
  2) 하나의 값이 다른 데이터 타입들을 가질 수 있도록 하는 법이다.     

**즉, 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미한다.**    
한마디로, **특정한 타입을 미리 지정해주는 것이 아닌, 필요에 의해 지정할 수 있도록 하는 일반타입**이다.    
(그래서 알고리즘 문제풀이 할 때 보다는, 웹개발 할 때 더 자주 응용했던 것 같다.)     
    
이 때문에, 
```
타입에 대해 유연성과 안정성을 확보 할 수 있다.      
(런타임에 발생할 수 있는 타입에러를 컴파일 전에 검출한다)     
```
      
이제 백준의 촌수계산 문제를 통해 제네릭과 배열의 차이점에 대해 알아보자.    
  **1) 배열은 공변, 제네릭은 불공변**       
+ 배열의 경우 sub가 super의 하위타입일 때, 
  + **공변하다** : sub[]는 super[]의 하위 타입
  + **불공변하다** : ArrayList\<sub>는 ArrayList\<super>의 하위타입이 아님
```java
Object[] obj = new String[1]; // 배열은 공변하므로 String[]은 Object[]의 하위 타입이므로 컴파일 가능

비고)
// obj는 컴파일 타임에 Object[]이므로 Integer을 할당 가능. 그러나, 런타임엔 String[]이기 때문에 예외가 발생함
obj[0] = 1;  
```
```java
ArrayList<Object> arrayList = new ArrayList<String>(); // 제네릭 타입은 불공변하므로 컴파일 불가능
```
  **2) 배열은 런타임에 타입이 실체화, 제네릭은 런타임에 소거**       
```java
Object[] obj = new Integer[1]; // 배열 obg는 런타임에 Integer[]가 된다
```
```java
// 컴파일 타임(실제 작성한 코드)
ArrayList<String> stringList = new ArrayList<String>();
ArrayList<Integer> integerList = new ArrayList<Integer>();

// 런타임(제네릭 타입은 런타임에 소거되므로 구분이 불가능하다)
ArrayList stringList = new ArrayList();
ArrayList integerList = new ArrayList();
```

따라서 **타입 안전성을 위해** 백준의 촌수계산 문제의 아래코드는 컴파일 에러가 발생할 수 밖에 없다. 
```java
List<Integer>[] list = new ArrayList<>[N+1]; // compile error
```


     
---
참고링크1 : [JAVA 제네릭 배열을 생성하지 못하는 이유](https://pompitzz.github.io/blog/Java/whyCantCreateGenericsArray.html#%E1%84%8C%E1%85%A6%E1%84%82%E1%85%A6%E1%84%85%E1%85%B5%E1%86%A8%E1%84%80%E1%85%AA-%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%E1%84%8B%E1%85%B4-%E1%84%8E%E1%85%A1%E1%84%8B%E1%85%B5%E1%84%8C%E1%85%A5%E1%86%B7)     
참고링크2 : [Java Array of ArrayList, ArrayList of Array](https://www.digitalocean.com/community/tutorials/java-array-of-arraylist-of-array)        
참고링크3 : ['generic array creation' compile error](https://multifrontgarden.tistory.com/258)   

