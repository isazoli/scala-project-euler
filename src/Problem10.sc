object Problem10 {
  import MyMathUtil._
   
  val s = Stepper.step(2)(List(2)).foldLeft(0L)(_ + _)
                                                  //> s  : Long = 277050

  object Stepper {
    //import MyMathUtil._
    import scala.annotation.tailrec
    @tailrec
    final def step(last: Int)(primes: List[Int]): List[Int] = if (last == 2000) primes else step(last + 1)(if (isPrime(last)(primes)) last :: primes else primes)
  }
}