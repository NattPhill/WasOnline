package ru.netology

fun main() {
    // Примеры вызова функции
    println(agoToText(30)) // только что
    println(agoToText(150)) // 2 минуты назад
    println(agoToText(3600)) // 1 час назад
    println(agoToText(7200)) // 2 часа назад
    println(agoToText(72000)) // 20 часов назад
    println(agoToText(100000)) // вчера
    println(agoToText(172801)) // позавчера
    println(agoToText(259201)) // давно
}

fun agoToText(secondsAgo: Int): String {
    return when {
        secondsAgo in 0..60 -> "был(а) только что"
        secondsAgo in 61..60 * 60 - 1 -> minutesAgo(secondsAgo)
        secondsAgo in 60 * 60..24 * 60 * 60 -> hoursAgo(secondsAgo)
        secondsAgo in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) в сети вчера"
        secondsAgo in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgo(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        minutes % 10 == 1 && minutes != 11 -> "был(а) в сети $minutes минуту назад"
        minutes % 10 in 2..4 && minutes !in 12..14 -> "был(а) в сети $minutes минуты назад"
        else -> "был(а) в сети $minutes минут назад"
    }
}

fun hoursAgo(seconds: Int): String {
    val hours = seconds / 3600
    return when {
        hours == 1 || hours == 21 -> "был(а) в сети $hours час назад"
        hours in 2..4 || hours in 22..24 -> "был(а) в сети $hours часа назад"
        else -> "был(а) в сети $hours часов назад"
    }
}