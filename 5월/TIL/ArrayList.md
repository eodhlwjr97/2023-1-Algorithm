##### 📝  
```
ArrayList<Integer> list = new ArrayList<>(); 에서 () 이게 하는 역할이 뭐야?    
```

()는 **생성자 호출**에 사용되는 것입니다. 생성자는 객체를 초기화하는 데 사용되는 특별한 메서드.    
Java에서 ArrayList 클래스의 생성자는 ArrayList<>();와 같이 호출됩니다.      
<Integer>은 제네릭(Generic) 타입 매개변수로, ArrayList가 저장할 요소의 타입을 지정합니다.     
여기서는 Integer 타입의 요소를 저장하는 ArrayList를 생성하고 있습니다.      
  
---   
##### 📝  
```
생성자 부분에 넣을 수 있는 타입은뭘까?
```

생성자 부분에는 다양한 타입을 넣을 수 있다.     
일반적으로 Java의 모든 참조 타입을 사용할 수 있습니다.     
예를 들어, Integer, String, Object 등과 같은 클래스 타입이나, 사용자가 정의한 클래스 타입을 사용할 수 있다.     
       
**비고) ArrayList의 생성자에 Map 타입을 사용하는 것은 불가능!**      
하지만, ArrayList과 유사한 동작을 하는 ArrayList<Map<K, V>>와 같은 형태의 구조를 사용하여 Map을 저장할 수 있습니다.     
이 경우 ArrayList의 각 요소는 Map 객체이며, 각 Map 객체는 키-값 쌍을 저장합니다.      
예를 들어, ArrayList<Map<String, Integer>>는 String 키와 Integer 값을 갖는 Map 객체들의 리스트를 나타냅니다.      
  
---
##### 📝  
```
ArrayList<Student> list = new ArrayList<>(map.values()); 에서 
map.values()는 Collection 인데 Collection (인터페이스)도 생성자에 넣을 수 있어?
```

```java
  public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }
```
=> 코드는 Java의 ArrayList 클래스의 생성자 중 하나이고(IDE 확인가능), 해당 생성자는 Collection을 인자로 받아 ArrayList 객체를 초기화한다.      

**즉, Java의 ArrayList 클래스는 Collection을 인자로 받는 생성자를 가지고 있습니다.**      
따라서 ArrayList의 생성자를 통해 Collection 객체를 직접 전달하여 ArrayList을 초기화할 수 있습니다.     
       
위의 코드에서 map.values()는 Collection<Student>를 반환하고, 이를 ArrayList<Student>의 생성자에 인자로 전달하여 list 객체를 초기화하고 있습니다.        
이렇게 하면 map의 값들이 ArrayList<Student>에 저장됩니다.
