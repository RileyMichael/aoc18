package aoc.impl

import aoc.AoCDay


class Day03 implements AoCDay {

    @Override
    def part1(List<String> input) {
        def fabric = new int[1000][1000]
        final def claims = parseClaims(input)
        def overlaps = 0

        // holy slow
        claims.each { c ->
            c.with {
                (x..<x2).each { i ->
                    (y..<y2).each { j ->
                        if (fabric[i][j] == 1)
                            overlaps++
                        fabric[i][j] += 1
                    }
                }
            }
        }

        return overlaps
    }

    @Override
    def part2(List<String> input) {
        return null
    }

    static def parseClaims(List<String> input) {
        input.collect { line ->
            final def matches = line =~ "^#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)\$"
            matches[0].with { new Claim(id: it[1] as String, x: it[2] as int, y: it[3] as int, width: it[4] as int, height: it[5] as int) }
        }
    }


    static final class Claim {
        String id
        int x, y, width, height
        @Lazy int x2 = x + width
        @Lazy int y2 = y + height
    }
}
