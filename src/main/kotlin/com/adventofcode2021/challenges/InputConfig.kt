package com.adventofcode2021.challenges

import org.slf4j.LoggerFactory
import java.io.File
import java.io.InputStream

class InputConfig {
    val logger = LoggerFactory.getLogger(this::class.java)
    
    fun setUpInput(inputFile: String, delimeter: String): List<String> {
        val inputStream: InputStream = File(inputFile).inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }
        
        return inputString.split(delimeter)
    }
    
}