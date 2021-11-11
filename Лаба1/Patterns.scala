
/** Напишите решение в виде функции. 
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching
{

  sealed trait Hand

  case object Rock extends Hand

  case object Paper extends Hand

  case object Scissor extends Hand




  sealed trait Result

  case object Win extends Result

  case object Lose extends Result

  case object Draw extends Result




  sealed trait Food

  case object Meat extends Food

  case object Vegetables extends Food

  case object Plants extends Food




  sealed trait Animal
  {

    val name: String
    val food: Food
  }

  case class Mammal(name: String, food: Food, weight: Int) extends Animal

  case class Fish(name: String, food: Food) extends Animal

  case class Bird(name: String, food: Food) extends Animal


  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def IntToString(a:Int):String = a match
  {
    case 1 =>"it is one"
    case 2 =>"it is two"
    case 3 =>"it is three"
    case _ => "what's that"
  }
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = IntToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max"
   *     "moritz" или "Moritz"
   */
  def isMaxAndMoritz(a:String):Boolean = if (a.toLowerCase== "max" || a.toLowerCase == "moritz") true else false

  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным 
  def isEven(a:Int):Boolean= (a%2) match
  {
    case 0 => true
    case 1 => false
  }

  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = isEven(value)


  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def WinsA(a:Hand, b:Hand):Result= a match
  {
    case Rock => b match
    {
      case Rock => Draw
      case Scissor => Win
      case Paper => Lose
    }
    case Paper => b match
    {
      case Rock => Win
      case Scissor => Lose
      case Paper => Draw
    }
    case Scissor=> b match
    {
      case Rock =>Lose
      case Scissor => Draw
      case Paper => Win
    }
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = WinsA(a,b)


  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def ExtractMammalWeight(animal: Animal):Int = animal match
  {
    case Mammal(name, food, weight)=>weight
    case _=> -1
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = ExtractMammalWeight(animal)


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.

  def updateFood(animal: Animal) = animal match
  {
    case Fish(name, food) =>Fish(name, Plants)
    case Bird(name, food) => Bird(name, Plants)
    case Mammal(name, food, weight) =>  Mammal(name, food, weight)
  }

  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)

}
