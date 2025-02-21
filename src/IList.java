
public interface IList<T extends Comparable<T>> {
	Node<T> prev(Node<T> node);

	Node<T> next(Node<T> node);

	T replace(Node<T> node, T item);

	Node<T> insertAfter(Node<T> node, T item);

	Node<T> insertBefore(Node<T> node, T item);
	public Node<T> addFirst(T item);
	public Node<T> addLast(T item);
	public T remove(Node<T> elem);
	public Node<T> search(T elem);
	public Node<T> first();
	
	
	public boolean isEmpty();
	public Integer size();
}
