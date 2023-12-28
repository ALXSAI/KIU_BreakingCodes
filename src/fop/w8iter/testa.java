package fop.w8iter;

public class testa {
    static class A {
            public A() {
                    System.out.println("A()");
            }
            public void h() {
                    System.out.println("A.h()");
            }
    }

    static class B extends A {
            public B() {
                    super();
                    System.out.println("B()");
            }
            public <T extends B> void f(K<T> k) {
                    System.out.println("B.f(K)");
                    K.g(null);
            }
    }

    static class C extends B {
            public C() {
                    System.out.println("C()");
            }
            public void h() {
                    super.h();
                    System.out.println("C.h()");
            }
    }

    static class K<T extends B> {
            public static void g(C c) {
                    System.out.println("K.g(C)");
            }
    }
    
    
    
    public static void main(String[] args)
    {
            A a = new A();
            B b = new B();
            C c = new C();
            K<B> k = new K<B>();
            A ac = c;
          
    
}
    	
    }

