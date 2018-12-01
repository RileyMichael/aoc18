package aoc.day

import aoc.AoCDay

class Day01 implements AoCDay {
    @Override
    def part1(List<String> input) {
        return input.sum {it as Integer}
    }

    @Override
    def part2(List<String> input) {
        def sum = 0
        def seen = [0] as HashSet<Integer>

        while (true) {
            for (num in input) {
                sum += num as Integer
                if (!seen.add(sum))
                    return sum
            }
        }
    }
}
