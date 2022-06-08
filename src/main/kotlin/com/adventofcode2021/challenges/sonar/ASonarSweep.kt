package com.adventofcode2021.challenges.sonar

import com.adventofcode2021.challenges.InputConfig
import org.slf4j.LoggerFactory

data class ReportValues(
    val data: Int,
    val status: Boolean? // increase = 1, decrease = 0
)

data class MapOfPoints(
    val point: Triple<Int, Int, Int>,
    val sum: Int,
    var status: String? = null
)

class ASonarSweep() {
    val logger = LoggerFactory.getLogger(this::class.java)
    
    fun startReportAnalysis(): MutableList<ReportValues> {
        val inputFile = "src/main/resources/inputfiles/ASonarSweep.txt"
        val report = InputConfig().setUpInput(inputFile, "\r\n").map {
            (it to Int).first.toInt()
        }
        
        val reportValues = mutableListOf<ReportValues>()
        reportValues.add(ReportValues(report[0], null))
        
        for (i in 1..report.size) {
            if (i < report.size) {
                val temp = report[i-1]
                if (report[i] - temp > 0 ) {
                    val new = ReportValues(report[i], true)
                    reportValues.add(new)
                } else {
                    val new = ReportValues(report[i], false)
                    reportValues.add(new)
                }
            }
        }
        
        return reportValues
    }
    
    fun performSweep() {
        val analysis = startReportAnalysis()
        val amountIncrease = analysis.count { it.status == true }
        val amountDecrease = analysis.count { it.status == false }

        logger.info("\nAmount of increases: $amountIncrease\nAmount decreses: $amountDecrease")
    }
    
    fun performSweepWithSum() {
        val inputFile = "src/main/resources/inputfiles/asonarswip2.txt"
        val inputString = InputConfig().setUpInput(inputFile, "\r\n")
    
        val data = inputString.map { (it to Int).first.toInt() }

        logger.info("Set = ", data.toString())
//        val data = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val list = mutableListOf<MapOfPoints>()
        var mapIndex = 0
    
        for (i in 0..data.size) {
            if (i + 2 < data.size) {
                val t = Triple(data[i], data[i+1], data[i+2])
                val sum = t.first + t.second + t.third
                list.add(MapOfPoints(t, sum))
            }
        }
        val listStatus = mutableListOf<String>()
        list.mapIndexed{ index, value ->
            if (index == 0) {
                listStatus.add("first element")
            } else if (list[index - 1 ].sum > value.sum) {
                listStatus.add("decreased")
            } else if (list[index - 1 ].sum < value.sum) {
                listStatus.add("increased")
            } else {
                listStatus.add("no change")
            }
        }
        val increased = listStatus.filter { it.contains("increased") }.size
        logger.info(listStatus.toString())
        
        logger.info(increased.toString())
    }
}
