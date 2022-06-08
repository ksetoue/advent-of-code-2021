package com.adventofcode2021.challenges

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChallengesApplication

fun main(args: Array<String>) {
	runApplication<ChallengesApplication>(*args)
	
//	Runner().drive()
	Runner().drivePart2()
}
