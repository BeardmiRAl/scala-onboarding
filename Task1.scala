object Task1 extends App {

  /*Дан массив чисел и целевое значение.
  Напишите программу, которая будет возвращать индексы 2 чисел,
  сумма которых равна целевому значению.*/

    def func_solution(nums: Array[Int], target: Int) ={
      val numbersMap = nums.zipWithIndex.filter( _._1 < target).toMap
      numbersMap.flatMap { case (value, index) =>
        numbersMap.get(target - value).map( _ -> index)
      }.headOption.getOrElse("no solutions")

      }

  /*
 def solution(nums: Array[Int], target: Int) = {

   var first = 0
   var last = nums.length - 1
   var found = false
   while (first < last && !found) {
     val s = nums(first) + nums(last)
     if (s == target) {
       found = true
     }
     else if (s < target) first += 1
     else last -= 1
   }
   val ans = Array(first, last)
   ans
*/
  val nums = Array(2, 7, 11, 15)
  val target = 9
  val result = Task1.func_solution(nums, target)
  println(s"Task 1 = ${result}") // List( 0, 1 )



}
