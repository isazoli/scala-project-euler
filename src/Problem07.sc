object Problem07 {
    // Problem 07

  def nextPrime(last: Int)(primes: List[Int])(acc: Int): Int = {
    if (acc == 101) {
      last
    } else {
      val next = last + 1
      if (isPrime(next)(primes)) {
        nextPrime(next)(primes.::(next))(acc + 1)
      } else {
        nextPrime(next)(primes)(acc)
      }
    }
  }                                               //> nextPrime: (last: Int)(primes: List[Int])(acc: Int)Int

  def isPrime(n: Int)(primes: List[Int]) = primes.forall(GCDHelper.gcd(n, _) == 1)
                                                  //> isPrime: (n: Int)(primes: List[Int])Boolean
	// Solution
  nextPrime(2)(List(2))(1)                        //> res0: Int = 547

  object GCDHelper {
    import scala.annotation.tailrec
    @tailrec final def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }
}