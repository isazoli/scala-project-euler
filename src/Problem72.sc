object Problem72 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // Problem 72
  // For 1000000 => Solution=303963552391
  val d = 1000                                    //> d  : Int = 1000

  def find(number: Int) = {
    def count(number: Int): Int = List.range(1, number, 1).count(gcd(_,number) == 1)
    
    import scala.annotation.tailrec
    @tailrec def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    
    val acc = List.range(0, number, 1).foldLeft(0L)((sum, x) => sum + count(x))
    println(acc)
  }                                               //> find: (number: Int)Unit

  find(d)                                         //> 303791

}