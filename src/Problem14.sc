import scala.annotation.tailrec

object Problem14 {

	X.recNext(13, 0)                          //> res0: Int = 9
	
  def count(top: Int) = {
		var max = (0,0)
    for (x <- 1 to top) {
      val curr = X.recNext(x, 0)
      if (curr > max._1)
        max = (curr, x)
    }
    max
  }                                               //> count: (top: Int)(Int, Int)
	
	count(13)                                 //> res1: (Int, Int) = (19,9)


  object X {
    @tailrec
    def recNext(n: Int, counter: Int): Int = {
      if (n == 1)
        counter
      else
        recNext(nextItem(n), counter + 1)
    }

    def nextItem(n: Int) = if (n % 2 == 0) (n / 2) else (3 * n + 1)
  }
}