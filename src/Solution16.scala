

object Solution16 {
  //  abstract class Numbers(number: Int, s: String, d: String) {
  //    case object _0 extends Numbers(0, "", "")
  //    case object _1 extends Numbers(1, "one", "-teen")
  //    case object _2 extends Numbers(2, "two", "twenty")
  //    case object _3 extends Numbers(3, "three", "thirty")
  //    case object _4 extends Numbers(4, "four", "fourty")
  //    case object _5 extends Numbers(5, "five", "fifty")
  //    case object _6 extends Numbers(6, "six", "sixty")
  //    case object _7 extends Numbers(7, "seven", "seventy")
  //    case object _8 extends Numbers(8, "eight", "eighty")
  //    case object _9 extends Numbers(9, "nine", "ninety")
  //  }

  def toSrt(number: Int): String = {

    val str = for {
      x <- 0 to 3
      decimal = Math.pow(10,x)
      curr  = (number / decimal) % 10
      value = Digit.unapply(curr.intValue)
    } yield (curr)
    println(str)
    ""
  }
  
  
  
  
  toSrt(123)
  
  
  abstract class Digit(number: Int, val s: String, d: String)
  case object _0 extends Digit(0, "", "")
  case object _1 extends Digit(1, "one", "teen")
  case object _2 extends Digit(2, "two", "twenty")
  case object _3 extends Digit(3, "three", "thirty")
  case object _4 extends Digit(4, "four", "fourty")
  case object _5 extends Digit(5, "five", "fifty")
  case object _6 extends Digit(6, "six", "sixty")
  case object _7 extends Digit(7, "seven", "seventy")
  case object _8 extends Digit(8, "eight", "eighty")
  case object _9 extends Digit(9, "nine", "ninety")

  def all = Array(_0, _1, _2, _3, _4, _5, _6, _7, _8, _9)

  object Digit {
    def unapply(x: Int): Digit = all(x)
  }
}
