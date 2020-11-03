/*Дана строка,
 содержащая прописные/строчные буквы алфавита и символы пробела.
 Верните длину последнего слова в строке. Если последнее слово не существует вывести 0*/

object Task3 extends App {
  def solution(s: String) = {
s.split(" ").lastOption.map(_.length).getOrElse(0)
    }




  println(s"Task 3 = ${Task3.solution("Hello World")}") //5
}