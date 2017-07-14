/*
Problem: write a tail recursive function to get the number of possible
compinations of 3 numbers that it's sum shouldn't exceed 200
The function will handle large numbers.
*/

import scala.annotation.tailrec

@tailrec
def get_number(l:List[Int], acc:Int, max_sum:Int, max_count:Int):Int = {
   l match {
     case Nil => acc
     case _ =>
       val length = {
       var sum = 0
       var count = 0
       l.takeWhile{ x =>
       sum = sum + x
       count = count + 1
       sum < max_sum && count <= max_count
     }.length
   }
     get_number(l.drop(length), acc+1, max_sum, max_count)
  }
}                                             

/* Testing the function with 1000000 random integer
import util.Random
val n = List.fill(1000000)(Random.nextInt(120))
println(get_number(n, 0, 200, 3))
*/
