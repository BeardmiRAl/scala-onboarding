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
    def turnsearch(nums: Array[Int], low: Int, high: Int): Int = {
      if (low > high) -1
      else {
        val middle = low + (high - low) / 2
        nums match {
          case nums: Array[Int] if (nums(middle) < nums(middle - 1) && nums(middle) < nums(middle + 1)) => middle
          case nums: Array[Int] if (nums(middle) > nums(low) && nums(middle) > nums(high)) => turnsearch(nums, middle, high)
          case nums: Array[Int] if (nums(middle) < nums(low) && nums(middle) < nums(high)) => turnsearch(nums, low, middle)
        }
      }
    }
    def BinarySearch(nums: Array[Int],
                     target: Int,
                     low: Int, high: Int): Int = {
      if (low > high) -1
      else {
        val middle = low + (high - low) / 2
        nums match {
          case (nums: Array[Int]) if (nums(middle) ==
            target) => middle
          case (nums: Array[Int]) if (nums(middle) <
            target) => BinarySearch(nums, target, middle + 1, high)
          case (arr: Array[Int]) if (arr(middle) >
            target) => BinarySearch(nums, target, low, middle - 1)
        }
      }
    }

    val turnpoint = turnsearch(nums, 0, nums.length - 1)
    if (target > nums(turnpoint) && target < nums.last) BinarySearch(nums, target, turnpoint, nums.indices.last)
    else if (target == nums(turnpoint)) turnpoint
    else if (target == nums.last) nums.indices.last
    else BinarySearch(nums, target, 0, turnpoint - 1)

  }
  val nums4 = Array(4, 5, 6, 7, 0, 1, 2)

  println(s"Task 4 = ${Task4.solution(nums4, 0)}") //  4
  println(s"Task 4 = ${Task4.solution(nums4, 3)}") // -1

}
