object Task12 extends App {

  def solution(s: String): Boolean = {
    val pattern = """(\s*-?[0-9]+\.?[0-9]*e?(?=([0-9]|-))-?[0-9]*\s*)|0?""".r
    pattern.matches(s)

  }

  println(s"Task 12 = ${solution("0")}") // true
  println(s"Task 12 = ${solution(" 0.1 ")}") // true
  println(s"Task 12 = ${solution("abc")}") // false
  println(s"Task 12 = ${solution("1 a")}") // false
  println(s"Task 12 = ${solution("2e10")}") // true
  println(s"Task 12 = ${solution(" -90e3   ")}") // true
  println(s"Task 12 = ${solution(" 1e")}") // false
  println(s"Task 12 = ${solution("e3")}") // false
  println(s"Task 12 = ${solution(" 6e-1")}") // true
  println(s"Task 12 = ${solution(" 99e2.5 ")}") // false
  println(s"Task 12 = ${solution("53.5e93")}") // true
  println(s"Task 12 = ${solution(" --6 ")}") // false
  println(s"Task 12 = ${solution("-+3")}") // false
  println(s"Task 12 = ${solution("95a54e53")}") // false


}
