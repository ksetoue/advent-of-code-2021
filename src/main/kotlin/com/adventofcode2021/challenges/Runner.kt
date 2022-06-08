package com.adventofcode2021.challenges

import com.adventofcode2021.challenges.sonar.ASonarSweep
import com.adventofcode2021.challenges.submarine.Command
import com.adventofcode2021.challenges.submarine.Ship
import org.slf4j.LoggerFactory

class Runner {
    val logger = LoggerFactory.getLogger(this::class.java)
    
    fun aSonarSweep() {
        ASonarSweep().performSweepWithSum()
    }
    
    fun drive() {
        val inputFile = "src/main/resources/inputfiles/drive.txt"
        val data = InputConfig().setUpInput(inputFile,"\r\n")
//
//        val data = "forward 5\n" +
//                "down 5\n" +
//                "forward 8\n" +
//                "up 3\n" +
//                "down 8\n" +
//                "forward 2"
        
        val commands = data.map {
            val position = it.split(" ").first()
            val units = it.split(" ").last()
            Command(position, units.toInt())
        }
        
        val result = Ship().findCurrentPosition(commands)
        logger.info("Drive! result = $result")
    }
    
    fun drivePart2() {
        val inputFile = "src/main/resources/inputfiles/drive2.txt"
        val data = InputConfig().setUpInput(inputFile,"\r\n")
        val commands = data.map {
            val position = it.split(" ").first()
            val units = it.split(" ").last()
            Command(position, units.toInt())
        }
        
//        val data = "forward 5\n" +
//                "down 5\n" +
//                "forward 8\n" +
//                "up 3\n" +
//                "down 8\n" +
//                "forward 2"
//        val commands = data.split("\n").map {
//            val position = it.split(" ").first()
//            val units = it.split(" ").last()
//            Command(position, units.toInt())
//        }
        
        val result = Ship().findCurrentPosition(commands)
        logger.info("Drive! result = $result")
    }
    
    fun binaryDiagnostic() {
//        val inputFile = "src/main/resources/inputfiles/drive2.txt"
//        val data = InputConfig().setUpInput(inputFile,"\r\n")
        
        val data = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010"
    }
}