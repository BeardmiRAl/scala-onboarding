import scala.collection.mutable

/*
По заданной строке найдите длину самой длинной подстроки без повторяющихся символов.
*/

object Task8 extends App {

    def solution(s: String): Int = {

        val visited = new mutable.HashMap[Character, Integer]
        var output = ""
        var start = 0
        var end = 0
        while (end < s.length) {
          val currChar = s.charAt(end)
          if (visited.contains(currChar)) start = Math.max(visited(currChar) + 1, start)
          if (output.length < end - start + 1) output = s.substring(start, end + 1)
          visited.put(currChar, end)

          end += 1
        }
        output.length
      }


    println(s"Task 8 = ${solution("abcabcbb")}")
    // 3

    println(s"Task 8 = ${solution("bbbbb")}")
    // 1

    println(s"Task 8 = ${solution("pwwkew")}")
    // 3

    println(s"Task 8 = ${solution("Kinoplan")}")
  }