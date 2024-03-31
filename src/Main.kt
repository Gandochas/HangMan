import kotlin.io.*
import java.io.File
import java.util.*

val scanner = Scanner(System.`in`)
val secretWord = selectWord()
var guessedLetters = mutableSetOf<Char>()
var guessedWord = currentWord(secretWord, guessedLetters)
const val MAX_INCORRECT_GUESSES = 6
var wrongGuesses = 0

//Производится выбор случайного слова для отгадывания из заданного словаря
fun selectWord(): String{
    val fileName = "C:\\Users\\Admin\\IdeaProjects\\Hang_game\\src\\words.txt"
    val randomWord = File(fileName).readLines().random()
    return randomWord
}

//Считывается символ введенный игроком
fun getPlayerInput(guessedLetters: MutableSet<Char>): String {
    while (true) {
        print("Guess a letter: ")
        val playerInput = if (scanner.hasNextLine()) scanner.nextLine().first().lowercase() else ""
        if (!guessedLetters.contains<Any>(playerInput) && playerInput.length == 1) {
            guessedLetters.add(playerInput.first())
        }
        return playerInput
    }
}

//Происходит построение слова с учетом отгаданных букв
fun currentWord(secretWord: String, guessedLetters: MutableSet<Char>): String{
    val currentLetters = StringBuilder()
    for (letter in secretWord){
        if (letter in guessedLetters){
            currentLetters.append(letter)
        } else {
            currentLetters.append('_')
        }
    }
    return currentLetters.toString().trim()
}

//Рисунок человечка через выбор элемента массива
fun drawHangedMan(wrongGuesses: Int) {
    val hangedMan = arrayOf(
        """
  -----
  |   |
      |
      |
      |
      |
      |
      |
      |
      |
-------
""",
        """
  -----
  |   |
  O   |
      |
      |
      |
      |
      |
      |
      |
-------
""",
        """
  -----
  |   |
  O   |
 ---  |
  |   |
  |   |
      |
      |
      |
      |
-------
""",
        """
  -----
  |   |
  O   |
 ---  |
/ |   |
  |   |
      |
      |
      |
      |
-------
""",
        """
  -----
  |   |
  O   |
 ---  |
/ | \ |
  |   |
      |
      |
      |
      |
-------
""",
        """
  -----
  |   |
  O   |
 ---  |
/ | \ |
  |   |
 ---  |
/     |
|     |
      |
-------
""",
        """
  -----
  |   |
  O   |
 ---  |
/ | \ |
  |   |
 ---  |
/   \ |
|   | |
      |
-------
"""
    )

    print(hangedMan[wrongGuesses])
}

//Определение конца игры
fun gameOver(wrongGuesses: Int, secretWord: String, guessedLetters: MutableSet<Char>): Boolean {
    if (wrongGuesses == MAX_INCORRECT_GUESSES){
        return true
    }
    if (secretWord.all { it in guessedLetters }) {
        return true
    }
    return false
}

fun main() {
    //Приветствие игрока
    println("Hello and welcome to HangGame!")
    while (!gameOver(wrongGuesses, secretWord, guessedLetters)){
        //Построение изначальной картинки
        drawHangedMan(wrongGuesses)
        //Показ? длины слова
        println("Your word is: $guessedWord")
        //Показ? пробных букв
        println("Current guessed letters: $guessedLetters")

        val playerGuess = getPlayerInput(guessedLetters)
        if (playerGuess in secretWord){
            println("Great guess!")
        } else {
            println("Wrong guess")
            wrongGuesses++
        }

        guessedLetters.add(playerGuess.first())
        guessedWord = currentWord(secretWord, guessedLetters)
    }

    drawHangedMan(wrongGuesses)
    if (!currentWord(secretWord, guessedLetters).contains('_')){//Условие победы
        println("You won!")
    } else if (wrongGuesses == MAX_INCORRECT_GUESSES){//Условие проигрыша
        println("You lost!")
    }
    println("Your word was: $secretWord")
}