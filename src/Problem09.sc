object Problem09 {
  for {
    x <- 1 to 1000
    y <- 1 to 1000 - x
    if (x * x + y * y == (1000 - x - y) * (1000 - x - y))
  } yield (x * y * (1000 - x - y))                //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(31875000, 31875000
                                                  //| )
}