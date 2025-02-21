import java.util.Collections;

/*
 * Total Marks SList Class: 26 Marks
 */
public class SList<T extends Comparable<T>> implements IList<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private Integer size = 0;
	
	/**
	 * Default constructor
	 */
	public SList() {}
	
	/**
	 * returns the first node in the list.
	 */
	public Node<T> first() {
		return head;
	}
	
	/**
	 * returns the last node in the list.
	 */
	public Node<T> last() {
		return tail;
	}
	
	/**
	 * returns the node before a given node in the list.
	 * 3 marks
	 */
	@Override
	public Node<T> prev(Node<T> node) {
		// if there's only a single node on the list
		if(head.next == null){
			return first();
		}
		// creating pointers to transverse
		Node<T> current = head, prev = null;

		// now I am transversing through the list till the end of it looking for the element, should there be multiple nodes on the list
		while(current != null){
			// should i find the element, current is at its position while prev is behind current
			if((current.element).compareTo(node.element) == 0){
				return prev; // return the node behind it
			}
			prev = current;
			current = current.next;
		}
		return null; // returning null should the given node not exist on the list
	}
	
	/**
	 * returns the next node after a given node in the list.
	 */
	@Override
	public Node<T> next(Node<T> node) {
		return node.getNext();
	}
	
	/**
	 * Replace the element of a given node in the list
	 * @return the old element of the given node
	 * 1 Marks
	 */
	@Override
	public T replace(Node<T> node, T item) {
		T temp = node.element;
		node.setElement(item);
		return temp;
	}
	
	/**
	 * Add an element after a given node in the list
	 * 3 Marks
	 */
	@Override
	public Node<T> insertAfter(Node<T> node, T item) {
		// declare new node
		Node<T> newNode = null;
		/*
			Creating pointer for transverse through the list
		 */
		Node<T> current = head;

		// first I have to check if the given node does exist on the list, so i will transverse through
		while (current != null){
			// should I find the element
			if((current.element).compareTo(node.element) == 0){
				newNode = new Node<>(current.next, item);
				current = newNode;
				size++;
				return newNode;
			}
			current = current.next;
		}

		return newNode; // will return null if the element is the givenNode isn't on the list
	}

	/**
	 * Add an element before a given node in the list
	 * 5 Marks
	 */
	@Override
	public Node<T> insertBefore(Node<T> node, T item) {
		// declaring new node
		Node<T> newNode = null;

		// pointers to transverse through the list
		Node<T> current = head, prev = null;

		// now transversing through the list
		while (current != null){
			// now check if we find that element
			if((current.element).compareTo(node.element) == 0){
				// now that we have found it, current is at it while prev is behind current
				newNode = new Node<>(current, item); // set newNode.Next to point to current
                assert prev != null;
                prev.next = newNode;// now set prev.next to point to the newNode
				size++;
				return newNode; // return the new node
			}
			prev = current;
			current = current.next;
		}

		return  newNode; // return null should the given node not exist on the list
	}

	/**
	 * Add an element to the start of the list
	 * @return the new node
	 */
	public Node<T> insertFirst(T item) {
		Node<T> newNode = new Node<T>(head, item);
		head = newNode;
		if (isEmpty())
			tail = head;
		size++;
		return newNode;	
	} 

	/**
	 * Add an element to the end of the list
	 * @return the new node
	 */
	public Node<T> insertLast(T item){
		Node<T> newest = new Node<T>(null, item);
		if (isEmpty())
		  head = newest;
		else
		  tail.setNext(newest);
		tail = newest;
		size++;
		return newest;
	}
	/*
	 * Alternate implementation (is actually wrong))
	public Node<T> addLast(T item){
		//TODO: Complete
		return addAfter(tail, item);
	}*/


	/**
	 * @param item the element we want to add to the list
	 * @return returns the new added node
	 */
	@Override
	public Node<T> addFirst(T item) {
		// declare new node
		Node<T> node = null;
		// should the list be empty, we then add the first element
		if(head == null){
			node = new Node<>(head, item);
			/*
				Since this will be our first node, then head and tail should point to it
			 */
			head = node;
			tail = node;
			// update size
			size++;
			return node; // return the node
		}

		/*
			Now suppose there's a single node on the list
		 */
		if(head.next == null){
			node = new Node<>(head, item);
			head = node;
			size++;
		}
		/*
			now say there are multiple nodes on the list
		 */
		node = new Node<>(head, item);
		head = node;
		size++;

		return node; // return the new added node
	}

	/**
	 * @param item  the element to be added at the end
	 * @return returns the last added node
	 */
	@Override
	public Node<T> addLast(T item) {
		// declare the new node
		Node<T> node = null;

		/*
			Creating pointers to transverse through the list
		 */
		Node<T> current = head;

		// should the list be empty, just add the element on the list
		if(head == null){
			return addFirst(item);
		}

		// should the list only contain a single element, them add the element after the tail, then tail points to the new node
		if(head == tail){
			node = new Node<>(tail.next, item);
			tail = node;
			size++;
		}

		//now assume there are multiple nodes on the list, we have to transverse to the end of the list
		while(current != tail){
			current = current.next;
		}
		// now we have reached the end of the list
		node = new Node<>(current.next, item);
		current = node;
		size++;
		return node; // return the last added node
	}

	/**
	 * Remove a specified node from the list. The removed element is returned
	 * 5 Marks
	 */
	@Override
	public T remove(Node<T> node) {
		// pointers to transverse through the list
		Node<T> current = head, prev = null;

		// now moving through the list looking for the node in the list
		while (current != null){
			// now if current has found the node on the list
			if(current == node){
                assert prev != null;
                prev.next = current.next; // set prev.next to skip current and point after current, thus removing the link between prev and current.
				size--;
				return current.element;
			}
			prev = current;
			current = current.next;
		}
		return null; // return null should the node not exist on the list
	}

	/**
	 * Returns the node that contains the element that is specified as a parameter
	 * 5 Marks
	 */
	@Override
	public Node<T> search(T elem) {
		// pointer to transverse through the list
		Node<T> current = head;

		// now transversing
		while(current != null){
			// if there is a single element on the list, just return first
			if(head == tail){
				return first();
			}
			// if we find the tail, just return the last element
			if(current == tail){
				return last();
			}
			// now looking if we do find this element
			if((current.element).compareTo(elem) == 0){
				return current;
			}
			current = current.next;
		}
		return null; // return null should the node with such element not exist on the list
	}

	/**
	 * Returns true if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Return the size of the list
	 */
	@Override
	public Integer size() {
		return size;
	}
	
	/**
	 * The overridden method for displaying items in the Singly-Linked List
	 * format: <e1><-><e2><-><e3><->
	 * 4 Marks
	 */
	@Override
	public String toString() {
		String result = "";
		Node<T> currentNode = head;

		while(currentNode != null){
			result += currentNode.element.toString();
			result += " -> ";
			currentNode = currentNode.next;
		}
		return result;
	}
}
