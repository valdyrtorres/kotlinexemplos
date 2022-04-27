fun calcArea(shape : Map<String, Any>) : Int {
    return shape["Height"] as Int * shape["Width"] as Int
}

fun toString(shape : Map<String, Any>) : String {
    return "Width = ${shape["Width"]}, Height = ${shape["Height"]}, Color = ${shape["Color"]}, Area = ${calcArea(shape)}"
}

fun main(args : Array<String>) {
    val rectangle = mutableMapOf("Width" to 10, "Height" to 10, "Color" to "Red")

    // Area calculation
    println("Area Calculation:")
    println(calcArea(rectangle))

    // ToString: You can customize the output, for example, in tis case we show:
    // Width, Height, Color and Area calculation
    println("Using kotlin without OOP")
    println(toString(rectangle))

    println("Changing width")
    rectangle["Width"] = 15
    println(toString(rectangle))

    println("Changing height")
    rectangle["Height"] = 80
    println(toString(rectangle))

    println("Changing color")
    rectangle["Color"] = "Blue"
    println(toString(rectangle))

    println("\n*****************************\n")
}