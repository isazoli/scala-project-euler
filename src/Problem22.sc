object Problem22 {
  val file = "C:\\sandbox\\workspace\\scala-project-euler\\src\\p022_names.txt"
                                                  //> file  : String = C:\sandbox\workspace\scala-project-euler\src\p022_names.txt
                                                  //| 
  lazy val names: Stream[String] = readFile(file).sortWith((x, y) => x < y)
                                                  //> names: => Stream[String]

  def readFile(file: String): Stream[String] = {
    val source = scala.io.Source.fromFile(file)
    val sp = for {
      line <- source.getLines
    } yield (line.split(','))

    sp.flatten.toStream
  }                                               //> readFile: (file: String)Stream[String]

  def score(input: String) = input.filter(_.toShort >= 'A'.toShort).foldLeft(0)((c, x) => c + (x.toShort - 'A'.toShort + 1))
                                                  //> score: (input: String)Int

  score("ABBEY")                                  //> res0: Int = 35
  score("COLIN")                                  //> res1: Int = 53
  score("WALLACE")                                //> res2: Int = 57

	val namesWithIdx = names.zipWithIndex     //> namesWithIdx  : scala.collection.immutable.Stream[(String, Int)] = Stream(("
                                                  //| AARON",0), ?)

  namesWithIdx.foldLeft(0)((count, xy) => { count + ((xy._2 +  1) * score(xy._1)) })
                                                  //> res3: Int = 871198282
}