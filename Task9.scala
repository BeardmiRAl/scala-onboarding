object Task9 extends App {

  def solution(s: String, p: String): Boolean = {
    val pattern = p.r
    pattern.findFirstIn(s).toList.head.length == s.length


  }

  println(s"Task 9 = ${solution("aa", "a")}")
  // false

  println(s"Task 9 = ${solution("aa", "a*")}")
  // true

  println(s"Task 9 = ${solution("ab", ".*")}")
  // true

  println(s"Task 9 = ${solution("aab", "c*a*b")}")
  // true

  println(s"Task 9 = ${solution("mississippi", "mis*is*p*.")}")
  // false
}
