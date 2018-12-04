package aoc.impl

import aoc.AoCDay

class Day04 implements AoCDay {

    @Override
    def part1(List<String> input) {
        final def guards = parseInput(input)
        def sleepiest = guards.values().max { it.total }
        def sleepiestMinute = sleepiest.highestMinute

        return sleepiestMinute * sleepiest.id
    }

    @Override
    def part2(List<String> input) {
        final def guards = parseInput(input)
        def sleepiest = guards.values().max { it.highestFreq }
        def sleepiestMinute = sleepiest.highestMinute

        return sleepiestMinute * sleepiest.id
    }

    static def parseInput(List<String> input) {

        // dates are ISO standard, can sort as string
        def guards = [] as HashMap<Integer, Guard>
        int start = 0, id = 0

        input.sort().each { event ->
            if (event.contains("Guard")) {
                id = (event =~ ".*#([0-9+]+).*")[0][1] as int
            } else if (event.contains("asleep")) {
                start = (event =~ ".*[0-9]+:([0-9]+).*")[0][1] as int
            } else if (event.contains("wakes")) {
                def guard = guards.get(id) ?: new Guard(id: id)
                def currentTime = (event =~ ".*[0-9]+:([0-9]+).*")[0][1] as int
                (start..<currentTime).each {
                    guard.sleepTime[it]++
                    guard.total++
                }
                guards.put(id, guard)
            }
        }

        return guards
    }

    static class Guard {
        int id
        int[] sleepTime = new int[60]
        int total

        def getHighestMinute() {
            sleepTime.findIndexOf { it == highestFreq}
        }

        def getHighestFreq() {
            GroovyCollections.max(sleepTime)
        }
    }
}
