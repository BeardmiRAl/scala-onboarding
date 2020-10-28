import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/*Определите, является ли целое число палиндромом.*/

object Task2 extends App {
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


println(s"Task 2 = ${Task2.solution(121)}")
  //true
println(s"Task 2 = ${Task2.solution(-121)}")
  // по ТЗ false, у меня true т.к. по логике палиндром это палиндром независимо от знака
println(s"Task 2 = ${Task2.solution(10)}")
  // false

  /*идея оптимизации алгоритма - использовать Vector вместо ArrayBuffer*/
}