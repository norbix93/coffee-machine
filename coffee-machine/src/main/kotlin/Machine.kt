class Machine(
    private var water: Int,
    private var milk: Int,
    private var beans: Int,
    private var cups: Int,
    private var money: Int
) {

    fun buy(type: String): String {
        val recipe = when (type) {
            // Array[Int](water, milk, beans, cups, money)
            "1" -> arrayOf(250, 0, 16, 1, 4)
            "2" -> arrayOf(350, 75, 20, 1, 7)
            "3" -> arrayOf(200, 100, 12, 1, 6)
            "back" -> return ""
            else ->
                throw RuntimeException("Wrong type of coffee: $type")
        }

        val response = when {
            (water - recipe[0] < 0) -> "Sorry, not enough water!"
            (milk - recipe[1] < 0) -> "Sorry, not enough milk!"
            (beans - recipe[2] < 0) -> "Sorry, not enough beans!"
            (beans - recipe[3] < 0) -> "Sorry, not enough cups!"
            else -> {
                water -= recipe[0]
                milk -= recipe[1]
                beans -= recipe[2]
                cups -= recipe[3]
                money += recipe[4]
                "I have enough resources, making you a coffee!"
            }
        }

        return response
    }

    fun take() {
        print("I gave you $" + money)
        money = 0
    }

    fun printState() {
        val msg = """
    The coffee machine has:
    $water of water
    $milk of milk
    $beans of coffee beans
    $cups of disposable cups
    $money of money """.trimIndent()

        print("\n" + msg)
    }

    fun addWater(amount: Int) {
        water += amount
    }

    fun addMilk(amount: Int) {
        milk += amount
    }

    fun addBeans(amount: Int) {
        beans += amount
    }

    fun addCups(amount: Int) {
        cups += amount
    }
}