package aoc

import aoc.impl.Day01
import aoc.impl.Day02
import aoc.impl.Day03

class App {

    static void main(String[] args) {
        final def DAYS = ["01": new Day01(),
                          "02": new Day02(),
                          "03": new Day03()] as LinkedHashMap<String, AoCDay>

        DAYS.each { day ->
            final def input = loadInputForDay(day.key)
            println("Day ${day.key} -")
            day.value.with {
                println("\tPart1: ${part1(input)}")
                println("\tPart2: ${part2(input)}")
            }
        }
    }

    private static loadInputForDay(String day) {
        try {
            getClass().getResource("/Day${day}.txt").readLines()
        } catch (IOException | NullPointerException ex) {
            throw new IOException(ex)
        }
    }
}
