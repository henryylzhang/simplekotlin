// Explore a simple class

println("UW Homework: Simple Kotlin")

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn (arg: Any): String {
	return when (arg) {
		"Hello" -> "world"
		"Howdy", "Bonjour" -> "Say what?" // why does the comma but || doesn't?
		0 -> "zero"
		1 -> "one"
		in 2..10 -> "low number"
		else -> "I don't understand"
	}
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add (first: Int, second: Int): Int {
	return first + second
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub (first: Int, second: Int) : Int {
	return first - second
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp (first: Int, second: Int, argFunc: (Int, Int) -> Int): Int { //why do we need an arrow here?
	return argFunc(first, second)
}

// write a class "Person" with first name, last name and age
class Person (val firstName: String, val lastName: String, var age: Int) { //why do we need variable types here?
	val debugString: String = "[Person firstName:${this.firstName} lastName:${this.lastName} age:${this.age}]"
	// this.age
	// 	get() = field
	// 	set(value) {
	// 		field = value
	// 	}
}

// write a class "Money"

// ============ DO NOT EDIT BELOW THIS LINE =============

print("When tests: ")
val when_tests = listOf(
    "Hello" to "world",
    "Howdy" to "Say what?",
    "Bonjour" to "Say what?",
    0 to "zero",
    1 to "one",
    5 to "low number",
    9 to "low number",
    17.0 to "I don't understand"
)
for ((k,v) in when_tests) {
    print(if (whenFn(k) == v) "." else "!")
}
println("")

print("Add tests: ")
val add_tests = listOf(
    Pair(0, 0) to 0,
    Pair(1, 2) to 3,
    Pair(-2, 2) to 0,
    Pair(123, 456) to 579
)
for ( (k,v) in add_tests) {
    print(if (add(k.first, k.second) == v) "." else "!")
}
println("")

print("Sub tests: ")
val sub_tests = listOf(
    Pair(0, 0) to 0,
    Pair(2, 1) to 1,
    Pair(-2, 2) to -4,
    Pair(456, 123) to 333
)
for ( (k,v) in sub_tests) {
    print(if (sub(k.first, k.second) == v) "." else "!")
}
println("")

print("Op tests: ")
print(if (mathOp(2, 2, { l,r -> l+r} ) == 4) "." else "!")
print(if (mathOp(2, 2, ::add ) == 4) "." else "!")
print(if (mathOp(2, 2, ::sub ) == 0) "." else "!")
print(if (mathOp(2, 2, { l,r -> l*r} ) == 4) "." else "!")
println("")


print("Person tests: ")
val p1 = Person("Ted", "Neward", 47)
print(if (p1.firstName == "Ted") "." else "!")
p1.age = 48
print(if (p1.debugString == "[Person firstName:Ted lastName:Neward age:48]") "." else "!")
println("")

// print("Money tests: ")
// val tenUSD = Money(10, "USD")
// val twelveUSD = Money(12, "USD")
// val fiveGBP = Money(5, "GBP")
// val fifteenEUR = Money(15, "EUR")
// val fifteenCAN = Money(15, "CAN")
// val convert_tests = listOf(
//     Pair(tenUSD, tenUSD),
//     Pair(tenUSD, fiveGBP),
//     Pair(tenUSD, fifteenEUR),
//     Pair(twelveUSD, fifteenCAN),
//     Pair(fiveGBP, tenUSD),
//     Pair(fiveGBP, fifteenEUR)
// )
// for ( (from,to) in convert_tests) {
//     print(if (from.convert(to.currency).amount == to.amount) "." else "!")
// }
// val moneyadd_tests = listOf(
//     Pair(tenUSD, tenUSD) to Money(20, "USD"),
//     Pair(tenUSD, fiveGBP) to Money(20, "USD"),
//     Pair(fiveGBP, tenUSD) to Money(10, "GBP")
// )
// for ( (pair, result) in moneyadd_tests) {
//     print(if ((pair.first + pair.second).amount == result.amount &&
//               (pair.first + pair.second).currency == result.currency) "." else "!")
// }
// println("")
