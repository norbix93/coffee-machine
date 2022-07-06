class MachineRunner(private val machine: Machine, private var expecting: Expected = Expected.ACTION) {
    fun takeLine(line: String) {
        when (expecting) {
            Expected.ACTION -> doAction(line)
            Expected.COFFEE_TYPE -> {
                println(machine.buy(line))
                awaitAction()
            }
            Expected.WATER_SET -> {
                machine.addWater(line.toInt())
                println("\nWrite how many ml of milk do you want to add: ")
                expecting = Expected.MILK_SET
            }
            Expected.MILK_SET -> {
                machine.addMilk(line.toInt())
                println("\nWrite how many grams of coffee beans do you want to add: ")
                expecting = Expected.BEANS_SET
            }
            Expected.BEANS_SET -> {
                machine.addBeans(line.toInt())
                println("\nWrite how many disposable cups of coffee do you want to add: ")
                expecting = Expected.CUPS_SET
            }
            Expected.CUPS_SET -> {
                machine.addCups(line.toInt())
                awaitAction()
            }
        }
    }

    fun doAction(action: String) {
        when (action) {
            "buy" -> {
                println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                expecting = Expected.COFFEE_TYPE
            }

            "fill" -> {
                println("\nWrite how many ml of water do you want to add: ")
                expecting = Expected.WATER_SET
            }

            "take" -> {
                machine.take()
                awaitAction()
            }

            "remaining" -> {
                machine.printState()
                awaitAction()
            }

            else -> {
                println("Unknown action: $action")
                awaitAction()
            }
        }

    }

    fun awaitAction() {
        println("\nWrite action (buy, fill, take, remaining, exit): ")
        expecting = Expected.ACTION
    }
}