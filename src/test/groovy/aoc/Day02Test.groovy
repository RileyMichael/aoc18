package aoc

import aoc.impl.Day02
import spock.lang.Specification

class Day02Test extends Specification {
    def "part 1 checksum"(List<String> input, int output) {
        expect:
            new Day02().part1(input) == output

        where:
            input                       |   output
            ["aabbc", ""]               |   0   // 1 * 0
            ["abbbcc", "aabb"]          |   2   // 2 * 1
            ["abbccc", "aabbcc", "ccc"] |   4   // 2 * 2
    }
}
