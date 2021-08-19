package danik.cesil

fun split(raw: String): List<String> {
	val arr: MutableList<String> = arrayListOf()

	var inString = false
	var thisString: MutableList<String> = arrayListOf()

	raw.split(' ').forEach { i ->
		if (i.startsWith('"') && !i.endsWith('"') && i != "\"") {
			inString = true
			thisString.add(i)
		} else if (i.endsWith('"') && !i.startsWith('"') && i != "\"") {
			inString = false
			thisString.add(i)
			arr.add(thisString.joinToString(separator = " "))
			thisString = arrayListOf()
		} else if (i == "\"") {
			if (inString) {
				inString = false
				thisString.add(i)
				arr.add(thisString.joinToString(separator = " "))
				thisString = arrayListOf()
			} else {
				inString = true
				thisString.add("\"")
			}
		} else if (inString) {
			thisString.add(i)
		} else {
			arr.add(i)
		}
	}

	return arr.filter { i -> i != "" }
}