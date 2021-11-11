
import scala.util.{Failure, Success, Try}
/* This task has no tests. It is an exercise for you to write different class structures.
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * 
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 */
/*class Animal(name1: String, species1: String, food1: String)
{
  var name: String = name1
  var species: String =species1
  var food: String = food1
  def set(animal: Animal ,name: String, food: Food):Animal=  animal(name,food)

 

}*/

/*
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 */


trait Animal
{
  val name: String
  val food: Food
}

trait Food

case object Meat extends Food

case object Vegetables extends Food

case object Plants extends Food

case class Mammal(name: String, food: Food) extends Animal

case class Birds(name: String, food: Food) extends Animal

case class Fishs(name: String, food: Food) extends Animal


object Animal
{
  
  def eats(animal: Animal, food:String): Boolean= food==animal.food
  
  
  def knownAnimals(name:String, list: List[String]):Boolean =
  {
    list.head==name match
    {
      case true => true
      case false => (list.size==0) match 
      {
        case true => false
        case false => list.size==1 match 
        {
          case true => false
          case false => knownAnimals(name, list.tail)
        }
      }
    }
  }
  
  
  def applyAnimals(name: String, list: List[Animal]): Option[Animal] =  list.head==name match
  {
    case true => Try(list.head).toOption
    case false => (list.size==0) match
    {
      case true => None
      case false => list.size==1 match
      {
        case true => None
        case false => applyAnimals(name, list.tail)
      }
    }
  }
}

/*
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *    
 *     который проверяет ест ли животное определенную пищу
  
 * d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 * 
 * e) Добавьте следующие функции в объект-компаньон Animal:
 *      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 * 
 * f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */
