import scala.math.Numeric.BigDecimalAsIfIntegral.mkOrderingOps

/** Напишите ваши решения в виде функций. */
object HigherOrder
{

  val plus: (Int, Int) => Int = _ + _
  val multiply: (Int, Int) => Int = _ * _
  
  

  /* a) Напишите функцию, которая принимает `f: (Int, Int) => Int`, параменты `a` и `b`
   *    и коэффициент умножения `n` и возвращает n * f(a, b). Назовите `nTimes`.
   */
  def nTimes(f:(Int, Int)=>Int, a:Int,  b:Int, n:Int):Int = n*f(a,b); //ready

  // примените вашу функцию (a) здесь, не изменяйте сигнатуру
  def testNTimes(f: (Int, Int)=> Int, a: Int, b: Int, n: Int): Int = nTimes(f,a,b,n) //ready

  /* b) Напишите анонимную функцию, функцию без идентификатора ((a, b) =>???  if (a > b) a else b) для `nTimes`
   */

   var anon= (a:Int, b:Int)=> if (a>b) a else b

  def testAnonymousNTimes(a: Int, b: Int, n: Int):Int =n*anon(a,b)
}
