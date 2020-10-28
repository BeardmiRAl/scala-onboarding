import scala.annotation.tailrec

/*
Дано подмножество различных целых чисел.
Верните все возможные подмножества (мощность множества).
*/

object Task5 extends App {
  def solution_lists(nums: Array[Int]) = {
    @tailrec
    def pww(t: List[Int], pl: List[List[Int]]): List[List[Int]] = {
      t match {
        case Nil => pl
        case head :: tail => pww(tail, pl ::: (pl.map(head :: _)))
      }
    }

    pww(nums.toList, Nil :: Nil)
  }


  val nums5 = Array(1, 2, 3)
  println(s"Task 5 = ${Task5.solution_lists(nums5)}")
  // List(
  //   List(3),
  //   List(1),
  //   List(2),
  //   List(1, 2, 3),
  //   List(1, 3),
  //   List(2, 3),
  //   List(1, 2),
  //   List()
  // )
}