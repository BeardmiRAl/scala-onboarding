/*Дана строка,
 содержащая прописные/строчные буквы алфавита и символы пробела.
 Верните длину последнего слова в строке. Если одно слово вывести 0*/

object Task3 extends App {
  def solution(s: String) = {
    if (s.contains(" ")) {
      val resd = s.reverse.split(" ")
      resd(0).length
    }
    else 0
  }

  println(s"Task 3 = ${Task3.solution("Hello World")}") //5
}