def is_sorted[T <% Ordered[T]](l:List[T]): Boolean = {
 l match {
   case a::b::xs if (a > b) => is_sorted(b::xs)
   case a::b::xs if (a < b) => false
   case _ => true
  }
}                                        
	
def one_cycle_bubble_sort[T <% Ordered[T]](l: List[T]): List[T] = {
 l match {
   case a::b::xs => if(a>b) a::one_cycle_bubble_sort(b::xs) else b::one_cycle_bubble_sort(a::xs)
   case c::Nil => c::Nil
   case Nil => Nil
 }		
}

def bubble_sort[T <% Ordered[T]](l: List[T]): List[T] = {
 if(is_sorted(l)){
   l
 }
 else{
   val new_l = one_cycle_bubble_sort(l)
    bubble_sort(new_l)
 }
}

/* Example
println(bubble_sort(List(1,10,9,7,6,5,4,2,3)))
List(10, 9, 7, 6, 5, 4, 3, 2, 1)
*/
