package com.adventofcode2021.challenges.diagnostic

data class DiagnosticsData(
    val gama: Int,
    val epsilon: Int
)

data class BinaryInput(
    val value: Int,
    val mostCommon: Int
)

class Binary {
    fun findPowerConsuption() {
    
    }
    
    fun binaryToInt(binaryData: List<String>): List<Int> {
         return binaryData.map {
            val zeros = countOccurrences(it, '0')
            val ones = countOccurrences(it, '1')
            
             val mostCommon = ones > zeros
             
            it.toInt(2)
         }
    }
    
    private fun countOccurrences(s: String, ch: Char): Int {
        return s.filter { it == ch }.count()
    }
}