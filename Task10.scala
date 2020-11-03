/*Дана n x n 2D матрица (двумерный массив) представляющая изображение.
Поверните изображение на 90 градусов (по часовой стрелке).
- Вы должны повернуть изображение на месте, что означает,
что вы должны изменить входную 2D матрицу напрямую. НЕ выделяйте другую 2D матрицу.
 */


object Task10 extends App {
  def solution(matrix: Array[Array[Int]]) = {
        val n = matrix(0).length - 1
        var temp = 0
        for (i <- 0 to n/ 2; j <- i until n-i) {
          temp = matrix(i)(j)
          matrix(i)(j) = matrix(n - j)(i)
          matrix(n - j)(i) = matrix(n - i)(n - j)
          matrix(n - i)(n - j) = matrix(j)(n - i)
          matrix(j)(n - i) = temp
        }


      for (i <- matrix) println(i.mkString(" "))
}




  val matrix1 = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  val matrix2 = Array(
    Array(5, 1, 9, 11),
    Array(2, 4, 8, 10),
    Array(13, 3, 6, 7),
    Array(15, 14, 12, 16),
  )

  println(s"Task 10 = ${solution(matrix1)}")
  //Array(
  //  Array(7, 4, 1),
  //  Array(8, 5, 2),
  //  Array(9, 6, 3)
  //)

  println(s"Task 9 = ${solution(matrix2)}")
  //Array(
  //  Array(15, 13, 2, 5),
  //  Array(14, 3, 4, 1),
  //  Array(12, 6, 8, 9),
  //  Array(16, 7, 10, 11)
  //)
}
