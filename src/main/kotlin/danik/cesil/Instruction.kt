package danik.cesil

class Instruction(parse: Array<String>) {
	lateinit var name: String
	lateinit var argument: Any

	init {
		// println(danik.cesil.parse.contentToString())

		val cmd = parse[0]
		val arg = if (parse.size == 1) "" else parse[1]

		when (cmd) {
			"IN", "OUT", "LINE" -> {
				name = cmd
				argument = "sus amogus"
			}

			"LOAD" -> {
				if (arg.startsWith('+') || arg.startsWith('-')) {
					name = "LOAD_CONST"
					argument = Integer.parseInt(arg)
				} else {
					name = "LOAD_LOCATION"
					argument = arg
				}
			}

			"STORE" -> {
				name = "STORE"
				argument = arg
			}

			"ADD" -> {
				if (arg.startsWith('+') || arg.startsWith('-')) {
					name = "ADD_CONST"
					argument = Integer.parseInt(arg)
				} else {
					name = "ADD_LOCATION"
					argument = arg
				}
			}

			"SUBTRACT" -> {
				if (arg.startsWith('+') || arg.startsWith('-')) {
					name = "SUB_CONST"
					argument = Integer.parseInt(arg)
				} else {
					name = "SUB_LOCATION"
					argument = arg
				}
			}

			"MULTIPLY" -> {
				if (arg.startsWith('+') || arg.startsWith('-')) {
					name = "MUL_CONST"
					argument = Integer.parseInt(arg)
				} else {
					name = "MUL_LOCATION"
					argument = arg
				}
			}

			"DIVIDE" -> {
				if (arg.startsWith('+') || arg.startsWith('-')) {
					name = "DIV_CONST"
					argument = Integer.parseInt(arg)
				} else {
					name = "DIV_LOCATION"
					argument = arg
				}
			}

			"JUMP" -> {
				name = "JMP"
				argument = arg
			}

			"JINEG" -> {
				name = "JMPN"
				argument = arg
			}

			"JIZERO" -> {
				name = "JMPZ"
				argument = arg
			}

			"PRINT" -> {
				name = "PRINT"
				argument = arg.substring(1, arg.length - 1)
			}

			"HALT" -> {
				name = "QUIT"
				argument = arg
			}

			else -> Error.commandNotFound()
		}
	}
}