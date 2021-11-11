object Hello
{
    def main(args: Array[String])
    {
        var dog = Mammal("Рекс", Meat)
        var bird = Birds("Popug", Vegetables)
        var fish = Fishs("Goldi", Plants)

        println(Animal.knownAnimals("Goldi", List(dog.name, bird.name, fish.name)))
        println(Animal.applyAnimals("Ares", List(dog, bird, fish)))
            
        println()
        
        println (HigherOrder.testNTimes(HigherOrder.plus, 1,2,4))
        println(HigherOrder.testAnonymousNTimes(1,2,3))

        println()
        
        println(PatternMatching.IntToString(3))
        println(PatternMatching.isMaxAndMoritz("naming"))
        
        println()
        
        println(Functions.rectangleUc(4,5))
        println(Functions.rectangle(4)(6))
    }
}
