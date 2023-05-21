#### 📝 LinkedList에서 Head와 Tail이 필요한 이유
```java
package day_0520;
class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class Solution {

	public static void main(String[] args) {
		Node newNode = new Node(1);
		
		Node node1 = null;
		Node node2 = null;
		
		node1 = newNode;
		node2 = newNode;
		
		// 둘은 같은 주소값을 공유한다
		System.out.println(node1); //day_0520_CodingTest.Node@2a139a55
		System.out.println(node2); //day_0520_CodingTest.Node@2a139a55
		
	}

}
```
