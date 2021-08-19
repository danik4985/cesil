package danik.cesil

fun main(args: Array<String>) {
	val from = args[0]
	val parsed = parse(from)
	val runtime = Runtime(parsed)

	runtime.start()
}