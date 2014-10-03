object Problem09 {
	import java.lang.Math.pow
  for {
    x <- 1 to 1000
    y <- 1 to 1000 - x
    if (pow(x,2) + pow(y,2) == pow(1000 - x - y, 2))
  } yield (x * y * (1000 - x - y))                //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(31875000, 31875000
                                                  //| )
}