# Виселица на Kotlin

Проект "Виселица" — это классическая текстовая игра в угадывание слов, реализованная на Kotlin. В этой игре игроку необходимо угадывать буквы в слове, имея ограниченное количество попыток. Если игрок не сможет угадать слово до того, как закончатся попытки, виселица будет построена, и игра закончится поражением.

## Функции

- Игра в консольном режиме.
- Возможность добавления новых слов в словарь игры.
- Отображение итоговой виселицы при проигрыше.

## Технологии

- Kotlin
- Gradle (для сборки проекта)

## Начало работы

Для запуска проекта необходимо иметь установленные JDK и Gradle. Следуйте инструкциям ниже для запуска игры.

### Требования

- JDK 1.8 или выше
- Gradle 6.0 или выше

### Установка и запуск

1. Клонируйте репозиторий на ваш локальный компьютер:
git clone https://github.com/Gandochas/HangMan.git
2. Перейдите в каталог проекта:
cd HangMan
3. Соберите проект с помощью Gradle:
gradle build
4. Запустите игру:
gradle run
## Как играть

- После запуска игры следуйте инструкциям на экране.
- Введите букву, чтобы попытаться угадать слово.
- Игра завершается, когда слово угадано полностью или когда заканчиваются попытки.

## Конфигурация

Для добавления новых слов в словарь игры отредактируйте файл `src/words.txt`, добавив слова, каждое с новой строки.

## Лицензия

Этот проект распространяется под лицензией MIT. Подробности смотрите в файле LICENSE.
