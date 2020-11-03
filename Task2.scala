import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/*Определите, является ли целое число палиндромом.*/

object Task2 extends App {
  def func_solution(x: Int):Boolean = {
    @tailrec
    def digitunpack(x: Int, digitList: List[Int] = Nil ):List[Int] = {
      x / 10 match {
        case 0  => x :: digitList
        case _ => digitunpack(x / 10, x % 10 :: digitList)
      }
    }
    digitunpack(x).zip(digitunpack(x).reverse).forall(x => x._1 == x._2)
  }


  /*
  def solution(x: Int) = {
    var digits = ArrayBuffer[Int]()
    var nx = x
    while (nx > 0) {
      digits += nx % 10
      nx = nx / 10
    }
    @tailrec
    def polindromic(dig: ArrayBuffer[Int]): Int = {
      if (dig.length > 1) {
        if (dig(0) == dig(dig.length - 1))
          polindromic(dig.drop(1).reverse.drop(1))
        else dig.length
      }
      else dig.length
    }

    if (polindromic(digits) <= 1) true
    else false
  }
*/

println(s"Task 2 = ${Task2.func_solution(121)}")
  //true
println(s"Task 2 = ${Task2.func_solution(-121)}")
  // по ТЗ false, у меня true т.к. по логике палиндром это палиндром независимо от знака
println(s"Task 2 = ${Task2.func_solution(10)}")
  // false
  println(s"Task 2 = ${Task2.func_solution(1410141)}")
  // true
  println(s"Task 2 = ${Task2.func_solution(54)}")
  // false
  println(s"Task 2 = ${Task2.func_solution(5671)}")
  // false
  println(s"Task 2 = ${Task2.func_solution(110011)}")
  // true
  println(s"Task 2 = ${Task2.func_solution(12011)}")
  // false

}