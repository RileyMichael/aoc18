package aoc.impl

import aoc.AoCDay

class Day02 implements AoCDay {

    @Override
    def part1(List<String> input) {
        def shared_letters = [:]

        input.each { line ->
            def freq = [:]
            line.each { c ->
                freq.put(c, freq.getOrDefault(c, 0) + 1)
            }
            freq.values().toSet().each {
                shared_letters.put(it, shared_letters.getOrDefault(it, 0) + 1)
            }
        }
        return shared_letters.getOrDefault(2, 0) * shared_letters.getOrDefault(3, 0)
    }

    @Override
    def part2(List<String> input) {
        return null
    }
}
