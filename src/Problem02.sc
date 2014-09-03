object Problem02 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def fibo(x : Int, y : Int)(l : List[Int]) : List[Int] = if (y < 4000000) fibo(y, x + y)(l.::(x + y)) else l
                                                  //> fibo: (x: Int, y: Int)(l: List[Int])List[Int]
  
  fibo(1,2)(List(1,2)).filter(_ % 2 == 0).sum     //> res0: Int = 4613732
}