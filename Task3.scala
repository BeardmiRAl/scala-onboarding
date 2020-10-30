/*Дана строка,
 содержащая прописные/строчные буквы алфавита и символы пробела.
 Верните длину последнего слова в строке. Если последнее слово не существует вывести 0*/

object Task3 extends App {
  def solution(s: String) = {
    val p = s.split(" ").lastOption.toList
    p.length match {
      case 0 => 0
      case _ => p.head.length
    }
    }




  println(s"Task 3 = ${Task3.solution("Hello World")}") //5
}