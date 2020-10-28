/*
 Предположим дан массив чисел отсортированный по возрастанию, и затем повернутый
 в некоторой опорной точке неизвестной вам заранее (т.е., [1, 2, 3, 4, 5, 6, 7]
 может стать [4,5,6,7,0,1,2]). И вам дано целевое значение для поиска. Если найдено э
 то значение, то вернуть его индекс, в противном случае вернуть -1.


 - Вы можете предполагать, что в массиве нет дубликатов.
 - Сложность времени выполнения вашего алгоритма должна быть порядка O(log n).
 */

object Task4 extends App {
  def solution(nums: Array[Int], target: Int) = {
    val numvector = nums.toVector
    numvector.indexOf(target)
  }

  val nums4 = Array(4, 5, 6, 7, 0, 1, 2)
  println(s"Task 4 = ${Task4.solution(nums4, 0)}") //  4
  println(s"Task 4 = ${Task4.solution(nums4, 3)}") // -1

  /* не уверен что имелось ввиду именно такое решение, */

}