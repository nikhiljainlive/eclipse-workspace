package newprograms;

class Node {
	String data;
	Node next;
}

public class TLinkedList {
	public Node head = null;

	public void insertAtLast(String data) {
		Node node = new Node();
		node.data = data;
		if (head == null) {
			head = node;
			node.next = null;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			node.next = null;
			n.next = node;
		}
	}

	public void delete(String element) {
		Node n = head;
		Node prev = head;
		if (n.data.equals(element)) {
			head = n.next;
			return;
		}
		while (n.next != null) {
			if (element.equals(n.data)) {
				prev.next = n.next;
				return;
			}
			prev = n;
			n = n.next;
		}
		prev.next = null;
	}

	public String deleteAtFirst() {
		String item;
		Node n = head;
		head = n.next;
		item = n.data;
		return item;
	}

	public String deleteAtLast() {
		if (head == null)
			return null;
		else {
			Node n = head;
			Node prev = head;
			while (n.next != null) {
				prev = n;
				n = n.next;
			}
			String data = n.data;
			prev.next = null;
			return (data);
		}
	}

	public void sortList() {
		Node n = head;
		Node prev;
		prev = n.next;
		while (n.next != null) {
			while (prev.next != null) {
				int a = Integer.parseInt(n.data);
				int b = Integer.parseInt(prev.data);
				if (a > b) {
					int t = a;
					n.data = String.valueOf(b);
					prev.data = String.valueOf(t);
				}
				prev = prev.next;
			}
			n = n.next;
			prev = n.next;
		}
	}

	public void show() {
		Node n = head;
		while (n.next != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.print(n.data + " ");
	}

	public String get() {
		Node n = head;
		if (n.next == null) {
			head = null;
			return n.data;
		}
		head = n.next;
		return n.data;
	}

	public boolean search(String element) {
		Node n = head;
		while (n != null) {
			if (element.equals(n.data))
				return true;
			n = n.next;
		}
		return false;
	}

	public String getElementAtPosition(int pos) {
		Node n = head;
		int cnt = 0;
		while (pos != ++cnt) {
			n = n.next;
		}
		return (n.data);
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

}
