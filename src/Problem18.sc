import scala.annotation.tailrec

object Problem18 {

  val inputMatrix: Array[Array[Int]] = Array(
    Array(3),
    Array(7, 4),
    Array(2, 4, 6),
    Array(8, 5, 9, 3))                            //> inputMatrix  : Array[Array[Int]] = Array(Array(3), Array(7, 4), Array(2, 4, 
                                                  //| 6), Array(8, 5, 9, 3))

  def combine(currLine: Array[Int], prevLine: Array[Int]): Array[Int] = {

    def maxFromPrevLine(idx: Int): Int = {
      import Math._
      prevLine.toList.slice(max(0, idx - 1), min(prevLine.length, idx + 1)).max
    }

    currLine
      .toList
      .zipWithIndex
      .map({ case (number, index) => number + maxFromPrevLine(index) })
      .toArray
  }                                               //> combine: (currLine: Array[Int], prevLine: Array[Int])Array[Int]

  def maxRec(mx: Array[Array[Int]]): Array[Int] = {
    mx match {
      case Array(Array(x: Int)) => Array(x)
      case _ => combine(mx.last, maxRec(mx.dropRight(1)))
    }
  }                                               //> maxRec: (mx: Array[Array[Int]])Array[Int]

  maxRec(Array(Array(3)))                         //> res0: Array[Int] = Array(3)

  maxRec(Array(Array(3), Array(7, 4)))            //> res1: Array[Int] = Array(10, 7)

  maxRec(Array(Array(3), Array(7, 4), Array(2, 4, 6)))
                                                  //> res2: Array[Int] = Array(12, 14, 13)

  maxRec(inputMatrix).max                         //> res3: Int = 23

  val p18 = Array(
    Array(75),
    Array(95, 64),
    Array(17, 47, 82),
    Array(18, 35, 87, 10),
    Array(20, 04, 82, 47, 65),
    Array(19, 01, 23, 75, 03, 34),
    Array(88, 02, 77, 73, 07, 63, 67),
    Array(99, 65, 04, 28, 06, 16, 70, 92),
    Array(41, 41, 26, 56, 83, 40, 80, 70, 33),
    Array(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
    Array(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
    Array(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
    Array(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
    Array(63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
    Array(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23))
                                                  //> p18  : Array[Array[Int]] = Array(Array(75), Array(95, 64), Array(17, 47, 82
                                                  //| ), Array(18, 35, 87, 10), Array(20, 4, 82, 47, 65), Array(19, 1, 23, 75, 3,
                                                  //|  34), Array(88, 2, 77, 73, 7, 63, 67), Array(99, 65, 4, 28, 6, 16, 70, 92),
                                                  //|  Array(41, 41, 26, 56, 83, 40, 80, 70, 33), Array(41, 48, 72, 33, 47, 32, 3
                                                  //| 7, 16, 94, 29), Array(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14), Array(70
                                                  //| , 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57), Array(91, 71, 52, 38, 17, 14
                                                  //| , 91, 43, 58, 50, 27, 29, 48), Array(63, 66, 4, 68, 89, 53, 67, 30, 73, 16,
                                                  //|  69, 87, 40, 31), Array(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4
                                                  //| , 23))
  maxRec(p18).max                                 //> res4: Int = 1074

  def readFile(file: String): Array[Array[Int]] = {
    val source = scala.io.Source.fromFile(file)
    val sp = for {
      line <- source.getLines
    } yield (line.split(' ').map(_.toInt))

    sp.toArray
  }                                               //> readFile: (file: String)Array[Array[Int]]
  
  //maxRec(readFile("c:\\@work\\p067_triangle.txt")).max // res5: Int = 7273
}