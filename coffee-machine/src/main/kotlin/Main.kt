fun main() {
    stageSix()
}

fun stageSix() {
    val machine = Machine(400, 540, 120, 9, 550)
    val runner = MachineRunner(machine)

    runner.awaitAction()

    while (true) {
        val line = readLine()!!
        if (line.trim().equals("exit")) {
            break
        }
        runner.takeLine(line)
    }
}
