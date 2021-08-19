package danik.cesil

data class ParsedData(
	var instructions: MutableList<Instruction>,
	var labels: Map<String, Int>,
	var data: MutableList<Int>
)
