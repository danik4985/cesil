package danik.cesil

import kotlin.system.exitProcess

class Error {
	companion object {
		fun divisionByZero() {
			println("*** DIVISION BY ZERO ***")
			exitProcess(1)
		}

		fun needMoreData() {
			println("*** PROGRAM REQUIRES MORE DATA ***")
			exitProcess(1)
		}

		fun labelNotFound() {
			println("*** LABEL NOT FOUND ***")
			exitProcess(1)
		}

		fun commandNotFound() {
			println("*** INSTRUCTION NOT FOUND ***")
			exitProcess(1)
		}
	}
}