object Problem17 {

  def length(num: Int): Int = numToString(num / 100, (num / 10) % 10, num % 10).length()
                                                  //> length: (num: Int)Int

  def oneDigitToStr(digit: Int): String = {
    digit match {
      case 0 => ""
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
    }
  }                                               //> oneDigitToStr: (digit: Int)String

  def decimalToStr(digit: Int): String = {
    digit match {
      case 1 => "ten"
      case 2 => "twenty"
      case 3 => "thirty"
      case 4 => "forty"
      case 5 => "fifty"
      case 8 => "eighty"
      case _ => oneDigitToStr(digit) + "ty"
    }
  }                                               //> decimalToStr: (digit: Int)String

  def numToString(hundred : Int, decimal: Int, digit: Int): String = {
    (hundred, decimal, digit) match {
    	// 1-digit
      case (0, 0, z) => oneDigitToStr(z)
      // 2-digit
      case (0, 1, 1) => "eleven"
      case (0, 1, 2) => "twelve"
      case (0, 1, 3) => "thirteen"
      case (0, 1, 4) => "fourteen"
      case (0, 1, 5) => "fifteen"
      case (0, 1, 6) => "sixteen"
      case (0, 1, 7) => "seventeen"
      case (0, 1, 8) => "eighteen"
      case (0, 1, 9) => "nineteen"
      case (0, y, 0) => decimalToStr(y)
      case (0, y, z) => decimalToStr(y) + oneDigitToStr(z)
      // 3-digit
      case (x, 0, 0) => oneDigitToStr(x) + "hundred"
      case (x, y, z) => oneDigitToStr(x) + "hundredand" + numToString(0, y, z)
    }
  }                                               //> numToString: (hundred: Int, decimal: Int, digit: Int)String

	20 == length(115)                         //> res0: Boolean = true
	23 == length(342)                         //> res1: Boolean = true

  val sum = List.range(1, 1000, 1).foldLeft(0)((sum, x) => sum + length(x)) + "onethousand".length()
                                                  //> sum  : Int = 21124

}