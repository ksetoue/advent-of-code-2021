package com.adventofcode2021.challenges.submarine

import org.slf4j.LoggerFactory

data class Position(
    var horizontal: Int,
    var depth: Int,
    var aim: Int
)

data class Command(
    val position: String,
    val units: Int
)

class Ship {
    val logger = LoggerFactory.getLogger(this::class.java)
    fun move(direction: String, units: Int, currentPostion: Position): Position {
        
        val currentPostion = when (direction) {
            "forward" -> processForwardCommand(currentPostion, units)
            "down" -> processDownCommand(currentPostion, units)
            "up" -> processUpCommand(currentPostion, units)
            else -> {
                logger.error("could not process position")
                throw Exception()
            }
        }
        
        return currentPostion
    }
    
    fun findCurrentPosition(commandList: List<Command>): Int {
        var currentPosition = Position(0,0, 0)
        commandList.map { it ->
            currentPosition = move(it.position, it.units, currentPosition)
        }
        
        
        return currentPosition.horizontal * currentPosition.depth
    }
    
    private fun processForwardCommand(currentPostion: Position, units: Int): Position {
        currentPostion.horizontal = currentPostion.horizontal + units
        currentPostion.depth = currentPostion.depth + currentPostion.aim * units
        return currentPostion
    }
    
    private fun processDownCommand(currentPostion: Position, units: Int): Position {
//        currentPostion.depth = currentPostion.depth + units
        currentPostion.aim = currentPostion.aim + units
        
        return currentPostion
    }
    
    private fun processUpCommand(currentPostion: Position, units: Int): Position {
//        currentPostion.depth = currentPostion.depth - units
        currentPostion.aim = currentPostion.aim - units
        
        return currentPostion
    }
}