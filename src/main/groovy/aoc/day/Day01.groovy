package aoc.day

import aoc.AoCDay

class Day01 implements AoCDay {
    @Override
    def part1(List<String> input) {
        return input.sum {it as Integer}
    }

    @Override
    def part2(List<String> input) {
        return null
    }
}
