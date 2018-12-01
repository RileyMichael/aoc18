package aoc

import aoc.day.Day01
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
}
