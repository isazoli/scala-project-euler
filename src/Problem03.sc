object Problem03 {


	def primeFactors(num : Long, primes : Set[Long]) : (Long, Set[Long]) = {
		if (num > 1) {
		var x = 1
		while (GCDHelper.gcd(num, x) == 1) {
			x += 1
		}
		primeFactors(num/x, primes.+(x))
		} else {
			(num, primes)
		}
	}                                         //> primeFactors: (num: Long, primes: Set[Long])(Long, Set[Long])
	val (x, primes) = primeFactors(600851475143L, Set())
                                                  //> x  : Long = 1
                                                  //| primes  : Set[Long] = Set(71, 839, 1471, 6857)
  primes.max                                      //> res0: Long = 6857
	

 object GCDHelper {
    import scala.annotation.tailrec
    @tailrec final def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)
  }
}