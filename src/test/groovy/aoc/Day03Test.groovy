package aoc

import aoc.impl.Day03
import spock.lang.Specification

class Day03Test extends Specification {
    def "part 1"(List<String> input, int output) {
        expect:
        new Day03().part1(input) == output

        where:
        input                               |   output
        ["#1 @ 2,2: 4x4", "#2 @ 3,3: 1x1"]  |   1
    }

    def "part 2"(List<String> input, String output) {
        expect:
        new Day03().part2(input) == output

        where:
        input                                               |   output
        ["#1 @ 2,2: 4x4", "#2 @ 3,3: 1x1", "#3 @ 8,8: 1x1"] | "3"
    }
}
