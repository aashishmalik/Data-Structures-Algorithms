package lec02an;

import lec29dec.Stack;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Stack s = new DynamicStack();

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.display();

	}

}
