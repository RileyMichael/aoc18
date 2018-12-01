package aoc

import aoc.impl.Day01
import spock.lang.Specification

class Day01Test extends Specification {
    def "part 1 frequency"(List<String> input, int output) {
        expect:
            new Day01().part1(input) == output

        where:
            input                           |   output
            ["+1", "-1", "+3", "+2", "-1"]  |   4
            ["-1", "-5", "+3"]              |   -3
    }

    def "part 2 repeating freq"(List<String> input, int output) {
        expect:
            new Day01().part2(input) == output

        where:
            input                           |   output
            ["+1", "-1"]                    |   0
            ["+3", "+3", "+4", "-2", "-4"]  |   10
            ["-6", "+3", "+8", "+5", "-6"]  |   5
            ["+7", "+7", "-2", "-7", "-4"]  |   14
    }
}
