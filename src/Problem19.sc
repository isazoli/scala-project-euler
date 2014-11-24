object Problem19 {
  def getNumberOfDays(year: Int, month: Int): Int = {
    month match {
      case 9 | 4 | 6 | 11 => 30
      case 2 if year % 4 != 0 => 28
      case 2 if year % 100 != 0 => 29
      case 2 if year % 400 != 0 => 28
      case 2 => 29
      case _ => 31
    }
  }                                               //> getNumberOfDays: (year: Int, month: Int)Int

  var dow: Int = 0                                //> dow  : Int = 0
  var counter = 0                                 //> counter  : Int = 0
  for (year <- 1900 to 2000; month <- 1 to 12; day <- 1 to getNumberOfDays(year, month)) {
    if (year > 1900 && day == 1 && dow == 6) {
      counter += 1
      //println(year,month,day)
    }
     dow = (dow + 1) % 7
  }
  println(counter)                                //> 171
}