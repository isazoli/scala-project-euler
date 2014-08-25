

object Problem01 {
  println("Welcome")                              //> Welcome
  // Problem 01
  def multipleOf3And5(top: Int) = List.range(0, top, 1).filter((i => i % 3 == 0 || i % 5 == 0)).sum
                                                  //> multipleOf3And5: (top: Int)Int
  multipleOf3And5(1000)                           //> res0: Int = 233168
}