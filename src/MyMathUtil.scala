object MyMathUtil {
  import scala.annotation.tailrec
  @tailrec final def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  final def isPrime(n: Int)(primes: List[Int]) : Boolean = primes.forall(gcd(n, _) == 1)
}