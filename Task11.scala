import scala.annotation.tailrec

/*
Дан набор различных целых чисел. Верните все возможные перестановки.
*/

object Task11 extends App {
  def solution(nums: Array[Int]): List[List[Int]] = {
    val base = nums.toList

    def spin(base: List[Int], ans: List[List[Int]]):List[List[Int]] = {
    if (ans.contains(base)) ans
    else spin (base.tail ::: List(base.head), base+: ans)
    }
    val ans = spin(base.reverse, List[List[Int]]()) ::: spin(base, List[List[Int]]())
    ans
  }


  val nums = Array(1, 2, 3)

  println(s"Task 11 = ${solution(nums)}")
  // List(
  //   List(1, 2, 3),
  //   List(1, 3, 2),
  //   List(2, 1, 3),
  //   List(2, 3, 1),
  //   List(3, 1, 2),
  //   List(3, 2, 1)
  // )
  }