package search

import java.io.File

class Search(args: Array<String>) {
    private val data: List<String>
    private val invertedIndex = mutableMapOf<String, MutableSet<Int>>()

    init {
        val file = File(args[1])
        data = file.readLines()
        data.forEachIndexed { index, string ->
            string
                .toUpperCase()
                .split(" ")
                .forEach {
                    if (invertedIndex[it] == null)
                        invertedIndex[it] = mutableSetOf(index)
                    else
                        invertedIndex[it]!!.add(index)
                }
        }
        menu()
    }

    private fun menu() {
        while (true) {
            println("\n=== Menu ===\n1. Search information.\n2. Print all data.\n0. Exit.")
            when (readLine()!!) {
                "1" -> find()
                "2" -> printAll()
                "0" -> break
                else -> println("Incorrect option! Try again.")
            }
        }
        println("Bye!")
    }

    private fun find() {
        val result: Set<Int>?

        println("Select a matching strategy: ALL, ANY, NONE")
        val matching = readLine()!!

        println("Enter a name or email to search all suitable people.")
        val query = readLine()!!
            .toUpperCase()
            .split(" ")
            .map { invertedIndex[it]?.toSet() }

        result = when (matching) {
            "ALL" -> query.reduce { acc, set ->
                if (acc != null && set != null) acc.intersect(set) else null
            }
            "ANY" -> query.reduce { acc, set ->
                when {
                    acc == null && set == null -> null
                    acc == null -> set
                    set == null -> acc
                    else -> acc.union(set)
                }
            }
            "NONE" -> {
                val dataTemp = data
                    .mapIndexed { i, s -> i to s }
                    .associate { it }
                    .toMutableMap()

                query
                    .reduce { acc, set -> if (acc != null && set != null) acc.union(set) else null }
                    ?.forEach { dataTemp.remove(it) }

                if (dataTemp.isNotEmpty()) dataTemp.map { it.key }.toSet() else null
            }
            else -> null
        }

        if (result == null)
            println("No matching people found.") else {
            result
                .joinToString("\n") { data[it] }
                .let(::println)
        }
    }

    private fun printAll() {
        println("=== List of people ===")
        data.forEach { println(it) }
    }
}

fun main(args: Array<String>) {
    Search(args)
}