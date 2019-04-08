package datastructures;

public class NodeQueue<T> {

	protected T data;
	protected NodeQueue<T> next;
	protected NodeQueue<T> prev;

	public NodeQueue(T data2) {
		this.data = data2;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeQueue<T> getNext() {
		return next;
	}

	public void setNext(NodeQueue<T> next) {
		this.next = next;
	}

	public NodeQueue<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeQueue<T> prev) {
		this.prev = prev;
	}

}
