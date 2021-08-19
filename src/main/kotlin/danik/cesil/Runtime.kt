package danik.cesil

import kotlin.system.exitProcess

class Runtime(data: ParsedData) {
	private var acumulator = 0
	private var dataPointer = 0
	private var instructionPointer = 0
	private val locations: MutableMap<String, Int> = mutableMapOf()

	private val instructions = data.instructions
	private val labels = data.labels
	private val data = data.data

	fun start() {
		while (instructionPointer < instructions.size) {
			runCommand(instructions[instructionPointer])
		}
	}

	private fun readData(): Int {
		return if (dataPointer < data.size) {
			val value = data[dataPointer]
			dataPointer++
			value
		} else {
			Error.needMoreData()
			0
		}
	}

	private fun location(x: String): Int = try { locations[x]!! } catch (ignored: Throwable) { 0 }

	private fun label(x: String): Int = try { labels[x]!! } catch (ignored: Throwable) {
		Error.labelNotFound()
		0
	}

	private fun runCommand(instruction: Instruction) {
		var next = instructionPointer + 1

		// println("N:" + instruction.name + "/A:" + instruction.argument)

		when (instruction.name) {
			"IN" -> acumulator = readData()
			"OUT" -> print(acumulator)
			"LINE" -> println()

			"LOAD_CONST" -> acumulator = instruction.argument as Int
			"LOAD_LOCATION" -> acumulator = location(instruction.argument as String)

			"STORE" -> locations[instruction.argument as String] = acumulator

			"ADD_CONST" -> acumulator += instruction.argument as Int
			"ADD_LOCATION" -> acumulator += location(instruction.argument as String)

			"SUB_CONST" -> acumulator -= instruction.argument as Int
			"SUB_LOCATION" -> acumulator -= location(instruction.argument as String)

			"MUL_CONST" -> acumulator *= instruction.argument as Int
			"MUL_LOCATION" -> acumulator *= location(instruction.argument as String)

			"DIV_CONST" -> acumulator /= if (instruction.argument as Int == 0) {
				Error.divisionByZero()
				69
			} else instruction.argument as Int
			"DIV_LOCATION" -> acumulator /= if (location(instruction.argument as String) == 0) {
				Error.divisionByZero()
				69
			} else location(instruction.argument as String)

			"JMP" -> next = label(instruction.argument as String)
			"JMPN" -> if (acumulator < 0 ) next = label(instruction.argument as String)
			"JMPZ" -> if (acumulator == 0 ) next = label(instruction.argument as String)

			"PRINT" -> print(instruction.argument)

			"QUIT" -> exitProcess(0)
		}

		instructionPointer = next
	}

}