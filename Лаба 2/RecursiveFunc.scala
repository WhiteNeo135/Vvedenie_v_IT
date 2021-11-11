

import scala.annotation.tailrec

/** Реализуйте функции для решения следующих задач.
  * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
  * рекурсия будет хвостовой если:
  *   1. рекурсия реализуется в одном направлении
  *   2. вызов рекурсивной функции будет последней операцией перед возвратом
  */
object RecursiveFunctions
{

  def length[A](as: List[A]): Int =
  {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match
    {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil() => agg
    }

    loop(as, 0)
  }

  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */


  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def reverse[A](list: List[A]): List[A] =
  {
    {
      @tailrec
      def loop(rem: List[A], num: List[A]): List[A]
      = rem match
      {
        case Nil() => num
        case Cons(x, y) => loop(y, Cons(x, num))
      }

      loop(list, Nil())
    }
  }


  var list1 = Cons[Int](5, Cons[Int](10, Nil[Int]()))
  var reversed=reverse(list1)

  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */


  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def map[A, B](list: List[A])(f: A => B): List[B] =
  {
    @tailrec
    def loop(l: List[A], num: List[B]): List[B] = l match
    {
      case Nil() => reverse(num)
      case Cons(x, y) => loop(y, Cons(f(x), num))
    }

    loop(list, Nil())
  }

  val list2 = Cons[Int](10, Cons[Int](20, Nil[Int]()))
  val func = (a: Int) => a * 2
  val mapped = map(list2)(func)
  
  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */

  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def append[A](l: List[A], r: List[A]): List[A] = l match
  {
    case Nil() => r
    case Cons(h, t) => Cons(h, append(t, r))
  }
  
  val appended=append(list1,list2)
  
  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */


  // используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
  def flatMap[A,B](list: List[A])(f: A=>List[B]): List[B] =
  {
    @tailrec
    def loop(l: List[A], num: List[B]): List[B] = l match
    {
      case Nil() => reverse(num)
      case Cons(x, y) => loop(y, append(f(x), num))
    }

    loop(list, Nil())
  }
  var l4 = Cons[Cons[Int]](Cons[Int](1 , Nil[Int]()), Cons[Cons[Int]](Cons[Int](2 , Nil[Int]()), Nil[Cons[Int]]()))
  var func1: List[Int] => List[Int] = _ match {
    case Cons(head, tail) => Cons(head,tail)
    case Nil() => Nil()
  }
  val flatMapped = flatMap(l4)(func1)

}
