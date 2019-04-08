/******************************************************************************** 
 * Purpose: implimenting the queue using linked list 
 *  
 *
 * @author  Rakshith A S
 * @version 1.0
 * @since   17-01-2019
 ********************************************************************************/
package datastructures;

public class Queue<T> {

	NodeQueue<T> head;
	NodeQueue<T> last;
	long length = 0;

	public Queue() {
		this.head = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void enQueue(T data) {
		NodeQueue<T> temp = new NodeQueue<T>(data);
		if (isEmpty()) {
			head = temp;
		} else {
			last.setNext(temp);
		}
		last = temp;
		length++;
	}

	public T deQueue() {
		T item = null;
		if (isEmpty()) {
			System.out.println("No item");
		} else {
			item = head.data;
			head = head.next;
			length--;
		}

		return item;
	}

	public void show() {
		NodeQueue<T> temp;
		temp = head;
		while (temp != null) {
			temp = temp.getNext();
		}
	}
}
