package org.yagamipaul.tools.logfilecleaner

import com.google.common.base.Stopwatch
import org.yagamipaul.tools.logfilecleaner.dto.ProcessResults
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Processor
 * 2017-08-10
 *
 * @author [Jean Paul Manjarres Correal](paul.manjarres@gmail.com)
 * @since 0.0.1
 */
class LogCleanerProcessor (
        val inputFile: File,
        val outputPath: File,
        val patterns: Set<String>) {

    /**
     * Suffix for the cleaned files
     */
    private val SUFFIX: String = "CLEANED"


    /**
     * Starts the cleaning process
     */
    fun start() : ProcessResults {


        val fileName = inputFile.name
        val index = fileName.lastIndexOf(".")
        val name = fileName.substring(0, index)
        val ext = fileName.substring(index + 1)

        val outputFileName = "$fileName.$ext"
        val outputFile = File(this.outputPath.absolutePath + File.separator + outputFileName)


        val timer: Stopwatch = Stopwatch.createStarted()

        println("File: ${inputFile.name} Size: ${inputFile.length() / 1024}")

        timer.stop()

        println("Total ellapsed time: ${timer.elapsed(TimeUnit.MILLISECONDS)} ms")


        return ProcessResults(
                inputFileName = inputFile.absolutePath,
                outputFileName = outputFileName,
                outputFileAbsolutePath = outputFile.absolutePath,
                inputFileSizeKB = 0,
                outputFileSizeKB = 0,
                initialLineCount = 0,
                finalLineCount = 0,
                millis = 0
        )
    }

}