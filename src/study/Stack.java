package study;

import java.util.NoSuchElementException;

public class Stack<T> {
	
	private class StackNode {
		
		private T data;
		
		private StackNode next = null; 
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	
	private StackNode top;
	
	
	public T pop() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		
		T item = top.data;
		this.top = this.top.next;
		return item;
	}
	
	public void push(T data) {
		
		StackNode newNode = new StackNode(data);
		
		newNode.next = this.top;
		this.top = newNode;
		
	}
	
	public T peak() {
		if (this.top == null) {
			throw new NoSuchElementException();
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
}
