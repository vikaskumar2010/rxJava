package com.rx.java.demo;

import io.reactivex.*;

public class RxJavaDemo {
  public static void main(String[] a) {

    demo1();
    // demo2();

  }

  public static void demo2() {
    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
    Observable<String> observable = Observable.fromArray(letters);
    observable.subscribe(

        i -> {
          if ( i.equalsIgnoreCase("a") || i.equalsIgnoreCase("d") ) {
            Thread.sleep(1000);
          }

          System.out.println(i);
        }, // OnNext

        Throwable::printStackTrace, // OnError

        () -> System.out.println("_Completed") // OnCompleted
    );
  }

  public static void demo1() {
    Flowable<Integer> flowable = Flowable.range(1, 10);
    flowable.subscribe(

        i -> {
          if ( i == 3 ) {
            throw new RuntimeException("MESSAGE");
          }

          System.out.println(i);
        }, // OnNext

        e -> {
          System.out.println("Exception OCCURED:" + e.getMessage());
        }, // OnError

        () -> System.out.println("_Completed") // OnCompleted



    );
  }
}
