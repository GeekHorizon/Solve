package leetcode;

import leetcode.Nav.Direction;

public class Test extends Nav implements Foo {
	
	
	public static void main(String[] args) {
		Test test = new Test();
		 new Test().testFoo();
		
	}

	 class A implements Foo {
         public int bar() { return 1; }

		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
    }

    public int fubar( Foo foo) { return foo.bar(); }

    public void testFoo() {

         class A implements Foo {
              public int bar() { return 2; }

			@Override
			public void test() {
				// TODO Auto-generated method stub
				
			}
         }

         System.out.println( fubar( new A()));
    }
    
    @Override
    public void test() {
    }

	@Override
	public int bar() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Nav {
	
	void test() {
		
	}
	
	
	public enum Direction {NORTH, SOUTH, EAST, WEST }
}

 interface Foo {
      int bar();
      public void test();
 }


 