package danik.cesil

import java.io.File

fun parse(path: String): ParsedData {
	val array: MutableList<Instruction> = mutableListOf()
	val labels: MutableMap<String, Int> = mutableMapOf()
	val data: MutableList<Int> = mutableListOf()

	var mode = "CODE"
	var line = -1

	File(path).forEachLine { i ->
		if (i.trim() == "" && i.startsWith('*')) return@forEachLine
		line++

		if (i == "*") {
			mode = "CODE"
		} else if (i == "%") {
			mode = "DATA"
		} else if (mode == "CODE") {
			val splited = split(i)

			if (splited.size == 3) {
				labels[splited[0]] = line
				array.add(Instruction(arrayOf( splited[1], splited[2] )))
			} else if (splited.size == 2 && (
								splited[1] == "IN"
												|| splited[1] == "OUT"
												|| splited[1] == "LINE"
							)) {
				labels[splited[0]] = line
				array.add(Instruction(arrayOf( splited[1] )))
			} else array.add(Instruction(splited.toTypedArray()))
		} else {
			data.add(Integer.parseInt(i))
			line-- // Dont add in data mode
		}
	}

	return ParsedData(
		instructions = array,
		labels = labels,
		data = data
	)
}